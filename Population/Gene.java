package Population;

import Configuration.Config;

import java.util.Random;

public class Gene {
    int allele = 0;

    /**
     * Generates a random gene
     */
    public Gene() {
        // Sets the values randomly between 0 and 1
        allele = new Random().nextInt(2);
    }

    /**
     * Generates a gene from pre-computed alleles
     * @param allele The pre-computed alleles
     */
    public Gene(int allele) {
        this.allele = allele;
    }
}
