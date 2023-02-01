package test;

import java.util.HashMap;

import geneticalgo.Chromosome;

public class Polynomial extends Chromosome{

    protected HashMap<Integer, Term> terms;
    protected double[] xt;
    protected double[] yt;

    public HashMap<Integer,Term> getTerms() {
        return this.terms;
    }

    public double[] getXt() {
        return this.xt;
    }

    public double[] getYt() {
        return this.yt;
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

        return null;

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

    public Polynomial(HashMap<Integer, Term> terms, double[] xt, double[] yt){

        this.terms = terms;
        this.xt = xt;
        this.yt = yt;

    }
    
}
