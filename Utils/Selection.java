package Utils;

import Population.Individual;
import Population.Population;

import java.util.Random;

public class Selection {

    /**
     * Roulette method to select an individual randomly from a population
     * @param pop The population to get the individual from
     * @return The chosen individual
     */
    public static Individual roulette(Population pop) {
        Individual selectedIndividual = new Individual(); // Creates a new individual

        double sommeFitness = pop.getSumOfFitness(); // Gets the sum of the fitness scores
        Random r = new Random(); // Creates a random object
        double randomPick = (sommeFitness * r.nextDouble()); // Generates a random number between 0 and the sum of the fitness scores

        // For each individual
        for (int i = 0 ; i < pop.getPopSize()-1 ; i++) {
            // If the random number is greater than the sum of the fitness scores of the previous individuals
            if (randomPick >= pop.getPopulation()[i].getFitnessScore() && randomPick < pop.getPopulation()[i + 1].getFitnessScore()) {
                selectedIndividual = pop.getPopulation()[i]; // The selected individual is the current individual
            }
        }

        return selectedIndividual; // Returns the selected individual
    }
}
