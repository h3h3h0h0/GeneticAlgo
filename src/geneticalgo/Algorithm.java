package geneticalgo;

import java.util.*;

public class Algorithm{

    protected ArrayList<Chromosome> population;
    protected int generation;
    //the population size to cull to
    protected int popSize;
    //the range of offspring numbers (i.e. the amount of new instances produced by a pair of chromosomes)
    protected int minOffspring;
    protected int maxOffspring;
    //proportion of the population that mutates
    protected double mutationChance;
    //the number of parents that continue into the next generation (before culling)
    //the best of the parents are chosen first
    protected int survivalNum;

    //advance 1 generation
    public void iterate(){

        ArrayList<Chromosome> offspring = mutate(createOffspring());
        population = getBest(survivalNum);
        population.addAll(offspring);
        cull();

    }

    //generate offspring from the current population
    protected ArrayList<Chromosome> createOffspring(){

        //randomize the population
        Collections.shuffle(population);
        ArrayList<Chromosome> offspring = new ArrayList<>();

        //pair up the adjacent parents (since already randomized)
        //randomly generate the amount of offspring based on constraints
        for(int i = 0; i < population.size()-1; i += 2){
            
            int numOffspring = minOffspring+(int)(Math.random()*(maxOffspring-minOffspring+1));

            for(int j = 0; j < numOffspring; j++) offspring.add(population.get(i).breed(population.get(i+1)));

        }

        return offspring;

    }

    //mutate the current population according to the mutation chance
    protected ArrayList<Chromosome> mutate(ArrayList<Chromosome> offspring){

        Collections.shuffle(offspring);
        int numToMutate = Math.max((int)((double)(offspring.size())*mutationChance), offspring.size());
        for(int i = 0; i < numToMutate; i++) offspring.get(i).mutate();

        return offspring;

    }

    //cull the population to the target size
    protected void cull(){

        population = getBest(popSize);

    }

    //get the best <num> chromosomes in the population sorted from best to worst
    public ArrayList<Chromosome> getBest(int num){

        ArrayList<Chromosome> ret = population;
        Collections.sort(ret);
        while(ret.size() > num) ret.remove(ret.size()-1);

        return ret;

    }

}
