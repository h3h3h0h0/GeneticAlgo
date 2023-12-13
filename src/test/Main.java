package test;
import geneticalgo.GenAlgorithm;
import geneticalgo.Chromosome;
import test.Polynomial;
import test.Term;
import java.util.*;

public class Main {
    public static void main(String [] args) {

        //randomly generate a few points
        double[] xt = new double[50];
        double[] yt = new double[50];

        System.out.println("---GENERATING POINTS---");

        for(int i = 0; i < 50; i++) {
            xt[i] = Math.random()*100-50;
            yt[i] = Math.random()*100-50;
            System.out.println("Point " + (i+1) + ": (" + xt[i] + ", " + yt[i] + ")");
        }

        //create the arraylist of polynomials (we are going to make them quartic as an example)
        //we are aiming for 50
        ArrayList<Chromosome> p = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            HashMap<Integer, Term> terms = new HashMap<>();
            for(int j = 0; j <= 4; j++) {
                double ct = Math.random()*10.0-5.0;
                terms.put(j, new Term(ct, j));
            }
            p.add(new Polynomial(terms, xt, yt, 4));
        }

        //create the algorithm instance
        GenAlgorithm ga = new GenAlgorithm(p, 100, 10, 20, 0.75, 30);

        System.out.println("\n---ITERATING---");

        //iterate 1000 generations
        for(int i = 0; i < 10000; i++) {
            ga.iterate();
            System.out.println("Iteration: " + (i+1) + "/10000, Best COD: "+ ga.getBest(1).get(0).fitness());
        }

        //final result
        System.out.println("\n---RESULTS---");
        ((Polynomial)(ga.getBest(1)).get(0)).print();
        System.out.println("Coefficient of Determination: "+ ga.getBest(1).get(0).fitness());

    }
}
