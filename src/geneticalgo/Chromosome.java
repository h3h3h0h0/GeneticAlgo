package geneticalgo;

import java.util.ArrayList;

public abstract class Chromosome implements Comparable<Chromosome>{

    protected ArrayList<Object> genes;

    public abstract double fitness(); //a number calculated to represent how good a particular chromosome is
    public abstract Chromosome breed(Chromosome c); //a method that produces a single child based on parent genes
    public abstract Chromosome mutate(); //simulation of mutation, randomly changes the genes in some way

    //this is reversed, makes the best ones come first
    public int compareTo(Chromosome c){

        if(c.fitness() > this.fitness()) return 1;
        else if(c.fitness() == this.fitness()) return 0;
        else return -1;

    }

}
