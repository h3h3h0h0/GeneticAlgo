package test;

import java.util.HashMap;

import geneticalgo.Chromosome;

public class Polynomial extends Chromosome{

    protected HashMap<Integer, Term> terms;
    protected double[] xt;
    protected double[] yt;
    protected int degree;

    public HashMap<Integer,Term> getTerms() {
        return this.terms;
    }

    public double[] getXt() {
        return this.xt;
    }

    public double[] getYt() {
        return this.yt;
    }

    public int getDegree(){
        return this.degree;
    }


    //in this case, it uses the coefficient of determination
    @Override
    public double fitness() {

        double rss = 0, tss = 0;
        double mean = 0;
        for(double i : yt) mean += i;
        mean = mean/yt.length;
        for(int i = 0; i < xt.length; i++){

            rss += Math.pow(yt[i]-calculate(xt[i]), 2);
            tss += Math.pow(yt[i]-mean, 2);

        }

        return 1-rss/tss;

    }

    //combines the 2 polynomials at some random "join point"
    //which is one of the powers
    //this also means that the degree is bounded
    //by whatever the largest degree is in the parent set
    @Override
    public Chromosome breed(Chromosome c) {

        HashMap<Integer, Term> nt = new HashMap<>();
        HashMap<Integer, Term> ct = ((Polynomial) c).getTerms();
        int md = Math.max(degree, ((Polynomial) c).getDegree());
        int cod = (int)(Math.random()*(md+2));
        int nmd = 0;

        for(int i = 0; i <= md; i++){

            if(i >= cod){

                if(terms.containsKey(i)){
                    
                    nmd = i;
                    nt.put(i, terms.get(i));

                }

            }else{

                if(ct.containsKey(i)){
                    
                    nmd = i;
                    nt.put(i, ct.get(i));

                }

            }

        }

        return new Polynomial(nt, xt, yt, nmd);

    }

    @Override
    public void mutate() {
        // TODO Auto-generated method stub
        
    }

    public double calculate(double x){

        double res = 0;
        for(Term t : terms.values()){
            res += t.calculate(x);
        }
        return res;

    }

    public Polynomial(HashMap<Integer, Term> terms, double[] xt, double[] yt, int d){

        this.terms = terms;
        this.xt = xt;
        this.yt = yt;
        degree = d;

    }
    
}
