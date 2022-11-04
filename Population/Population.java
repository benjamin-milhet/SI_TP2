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
        Population nextGeneration = new Population(false); // Creates a new population
        Individual[] individualsOfNextGeneration = new Individual[Config.getPopulationSize()]; // Creates an array of individuals

        int i = 0; // Index of the next individual to be created
        while (i < individualsOfNextGeneration.length) { // While there are still individuals to be created
            Individual parent1 = Selection.roulette(this); // Selects the first parent
            Individual parent2 = Selection.roulette(this); // Selects the second parent
            Individual[] children = Crossing.cross2X(parent1, parent2); // Creates the children with a 2X crossing

            //Mutate the children
            children[0].doMutate();
            children[1].doMutate();

            individualsOfNextGeneration[i] = children[0]; // Adds the first child to the array
            i++;
            if (i < individualsOfNextGeneration.length) { // If there is still room for the second child
                individualsOfNextGeneration[i] = children[1]; // Adds the second child to the array
                i++;
            }
        }

        nextGeneration.setPopulation(individualsOfNextGeneration); // Sets the population of the next generation
        return nextGeneration; // Returns the next generation
    }

    // Getters and setters
    //  sum of all fitness scores
    public double getSumOfFitness() {
        double sumOfFitness = 0.0;
        for (Individual individual : this.population) {
            sumOfFitness += individual.getFitnessScore();
        }
        return sumOfFitness;
    }

    // find the best individual
    public Individual findBestIndividual() {
        int maxFitnessFound = 0;
        Individual bestIndividual = new Individual();

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
