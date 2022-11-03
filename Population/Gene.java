package Population;

import java.util.Random;

public class Gene {
    int allele;

    /**
     * Generates a random gene
     */
    public Gene() {
        // Sets the values randomly between 0 and 1
        allele = new Random().nextInt(2);
    }

}
