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
        Individual[] children = new Individual[2];
        int nbGenes = Config.getIndividualSize(); // nombre de genes dans le chromosome
        Gene[] geneOfFirstChild = new Gene[nbGenes];
        Gene[] geneOfSecondChild = new Gene[nbGenes];

        Random r = new Random(); // On initialise la fonction Random de Java
        int numGene1 = (r.nextInt() * nbGenes); // numero du premier gene a echanger
        int numGene2 = (r.nextInt() * nbGenes); // numero du deuxieme gene a echanger

        for(int i =0; i<Config.getIndividualSize(); i++) {
            if(i < numGene1 || i > numGene2) {
                geneOfFirstChild[i] = p1.getGenes()[i];
                geneOfSecondChild[i] = p2.getGenes()[i];
            } else {
                geneOfFirstChild[i] = p2.getGenes()[i];
                geneOfSecondChild[i] = p1.getGenes()[i];
            }
        }

        children[0] = new Individual(geneOfFirstChild);
        children[1] = new Individual(geneOfSecondChild);
        return children;
    }
}
