package geneticalgo;

import java.util.ArrayList;

public class Algorithm<T extends Chromosome>{

    protected ArrayList<T> population;
    protected int generation;
    //the population size to cull to
    protected int popSize;
    //the range of offspring numbers (i.e. the amount of new instances produced by a pair of chromosomes)
    protected int minOffspring;
    protected int maxOffspring;

    //advance 1 generation
    public void iterate(){

    }



}
