package test;

public class Term {

    private double coeff;
    private int power;

    public double calculate(double x){

        return coeff*Math.pow(x, power*1.0);

    }

    public Term(double c, int p){

        coeff = c;
        power = p;

    }

}
