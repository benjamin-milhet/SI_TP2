package Population;

import Configuration.Config;

public class Individual {
    Gene[] genes = new Gene[Config.getIndividualSize()];
    int fitness = 0;

    /**
     * Creates a randomly generated individual
     */
    public Individual() {
        for (int i=0 ; i<Config.getIndividualSize(); i++) {
            genes[i] = new Gene();
        }
        computeFitnessScore();
    }

    /**
     * Creates an individual from a pre-computed array of genes
     * @param genes The pre-computed array of genes
     */
    public Individual(Gene[] genes) {
        this.genes = genes;
        computeFitnessScore();
    }

    /**
     * Computes the fitness of the individual based on the research function
     */
    public void computeFitnessScore() {
        int sumFitness = 0;
        System.out.println("==========================================================");
        for (int i=0; i<Config.getIndividualSize(); i++) {
            sumFitness += this.genes[i].allele;
            System.out.println("sumFitness = " + this.genes[i].allele);
        }
        System.out.println("==========================================================");
        this.fitness = sumFitness;

    }

    public void doMutate() {
        for (int i=0; i<Config.getIndividualSize(); i++) {
            if (Math.random() < Config.getMutationRate()) {
                this.genes[i].allele = (this.genes[i].allele == 0) ? 1 : 0;
            }
        }
    }

    public int getFitnessScore() {
        return this.fitness;
    }

    public Gene[] getGenes() {
        return this.genes;
    }

    @Override
    public String toString() {
        return "Fitness score is " + getFitnessScore();
    }
}
