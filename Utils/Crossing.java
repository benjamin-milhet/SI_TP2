package Utils;

import Configuration.Config;
import Population.Gene;
import Population.Individual;

import java.util.Random;

public class Crossing {

    /**
     * Generates two children from two parents
     * @param p1 The first parent
     * @param p2 The second parent
     * @return An array of 2 individuals
     */
    public static Individual[] cross2X(Individual p1, Individual p2) {
        Individual[] children = new Individual[2]; // Creates an array of 2 individuals
        int nbGenes = Config.getIndividualSize(); // Gets the number of genes
        Gene[] geneOfFirstChild = new Gene[nbGenes]; // Creates an array of genes for the first child
        Gene[] geneOfSecondChild = new Gene[nbGenes]; // Creates an array of genes for the second child

        Random r = new Random(); // Creates a random object
        int numGene1 = (r.nextInt() * nbGenes); // Generates a random number between 0 and the number of genes
        int numGene2 = (r.nextInt() * nbGenes); // Generates a random number between 0 and the number of genes

        if (numGene1 > numGene2) { // If the first number is greater than the second
            int temp = numGene1; // Swaps the two numbers
            numGene1 = numGene2;
            numGene2 = temp;
        }

        for(int i =0; i<Config.getIndividualSize(); i++) { // For each gene
            if(i < numGene1 || i > numGene2) { // If the gene is not between the two random numbers
                geneOfFirstChild[i] = p1.getGenes()[i]; // The gene of the first child is the gene of the first parent
                geneOfSecondChild[i] = p2.getGenes()[i]; // The gene of the second child is the gene of the second parent
            } else {
                geneOfFirstChild[i] = p2.getGenes()[i]; // The gene of the first child is the gene of the second parent
                geneOfSecondChild[i] = p1.getGenes()[i]; // The gene of the second child is the gene of the first parent
            }
        }

        children[0] = new Individual(geneOfFirstChild); // Creates the first child
        children[1] = new Individual(geneOfSecondChild); // Creates the second child
        return children; // Returns the array of children
    }
}
