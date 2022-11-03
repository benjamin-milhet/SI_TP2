package Population;

import Configuration.Config;
import Utils.Crossing;
import Utils.Selection;

public class Population {
    private Individual[] population = new Individual[Config.getPopulationSize()];

    /**
     * Creates a new population
     * @param initialPopulation Whether this is the first population
     */
    public Population(boolean initialPopulation) {
        if (initialPopulation) {
            for (int i = 0; i < Config.getPopulationSize(); i++) {
                population[i] = new Individual();
            }
        }
    }

    public Population computeNextGeneration() {
        Population nextGeneration = new Population(false);
        Individual[] individualsOfNextGeneration = new Individual[Config.getPopulationSize()];

        System.out.println("ToDo - Select and make individuals reproduce to create a new Population");
        System.out.println(individualsOfNextGeneration.length);

        int i = 0;
        while (i < individualsOfNextGeneration.length) {
            Individual parent1 = Selection.roulette(this);
            Individual parent2 = Selection.roulette(this);
            Individual[] children = Crossing.cross2X(parent1, parent2);

            //Mutate the children
            children[0].doMutate();
            children[1].doMutate();

            individualsOfNextGeneration[i] = children[0];
            i++;
            if (i < individualsOfNextGeneration.length) {
                individualsOfNextGeneration[i] = children[1];
                i++;
            }
        }

        nextGeneration.setPopulation(individualsOfNextGeneration);
        return nextGeneration;
    }

    public double getSumOfFitness() {
        double sumOfFitness = 0.0;
        for (Individual individual : this.population) {
            sumOfFitness += individual.getFitnessScore();
        }
        return sumOfFitness;
    }

    public Individual findBestIndividual() {
        int maxFitnessFound = 0;
        Individual bestIndividual = new Individual();

        System.out.println("Config.getPopulationSize() " + Config.getPopulationSize());
        for (int i=0; i<Config.getPopulationSize(); i++) {
            System.out.println("Individual " + i + " has a fitness of " + population[i].getFitnessScore());
            if (this.population[i].getFitnessScore() > maxFitnessFound) {
                maxFitnessFound = this.population[i].getFitnessScore();
                bestIndividual = this.population[i];
            }
        }

        return bestIndividual;
    }

    public void setPopulation(Individual[] individuals) {
        this.population = individuals;
    }

    public int getPopSize() {
        return this.population.length;
    }

    public Individual[] getPopulation() {
        return this.population;
    }
}
