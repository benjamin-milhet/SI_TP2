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
        Individual selectedIndividual = new Individual();

        double sommeFitness = pop.getSumOfFitness(); // On calcule la somme des fitness
        Random r = new Random(); // On initialise la fonction Random de Java
        double randomPick = (sommeFitness * r.nextDouble()); // On tire un double au hasard entre 0 et la somme des fitness

        // On parcourt la population pour trouver l'individu qui correspond au double tiré au hasard
        for (int i = 0 ; i < pop.getPopSize()-1 ; i++) {
            // Si le double est compris entre la fitness de l'individu i et celle de l'individu i+1
            if (randomPick >= pop.getPopulation()[i].getFitnessScore() && randomPick < pop.getPopulation()[i + 1].getFitnessScore()) {
                selectedIndividual = pop.getPopulation()[i]; // On retourne l'individu i
            }
        }

        return selectedIndividual;
    }
}
