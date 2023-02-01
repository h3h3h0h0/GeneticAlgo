package test;

import java.util.ArrayList;

import geneticalgo.Chromosome;

public class Polynomial extends Chromosome{

    protected ArrayList<Term> terms;
    protected int[] xt;
    protected int[] yt;

    //in this case, it uses the coefficient of determination
    @Override
    public double fitness() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Chromosome breed(Chromosome c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void mutate() {
        // TODO Auto-generated method stub
    }

    public double calculate(double x){

        double res = 0;
        for(Term t : terms){
            res += t.calculate(x);
        }
        return res;

    }

    public Polynomial(ArrayList<Term> terms, int[] xt, int[] yt){

        this.terms = terms;
        this.xt = xt;
        this.yt = yt;

    }
    
}
