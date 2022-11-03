package Configuration;

public class Config {

    static _Config cfg = null;

    /**
     * A static class means only 1 object of this class can be instanciated at all times
     */
    private static class _Config {
        // Number of individuals in a population
        public static int populationSize = 0;
        // Number of genes per individual
        public static int individualSize = 0;
        // Number of allele per gene
        public static int geneSize = 0;
        // Number of generations to generate
        public static int numberOfGenerations = 0;

        // Mutation rate
        public static double mutationRate = 0;

        public _Config() {}
    }

    /**
     * Generates a configuration for the genetic algorithm from passes parameters
     * @param popSize size of each population to generate
     * @param indSize number of genes for each individual
     * @param geneSize number of alleles per gene for each individual
     * @param nbGeneration number of generations to generate (initial population included)
     */
    public static _Config createConfig(int popSize, int indSize, int geneSize, int nbGeneration, double mutationRate) {

        if (cfg == null) {
            cfg = new _Config();
            _Config.populationSize = popSize;
            _Config.individualSize = indSize;
            _Config.geneSize = geneSize;
            _Config.numberOfGenerations = nbGeneration;
            _Config.mutationRate = mutationRate;
        }

        return cfg;
    }

    public static int getPopulationSize() {
        return _Config.populationSize;
    }

    public static int getIndividualSize() {
        return _Config.individualSize;
    }

    public static int getGeneSize() {
        return _Config.geneSize;
    }

    public static int getNumberOfGenerations() {
        return _Config.numberOfGenerations;
    }

    public static double getMutationRate() {
        return _Config.mutationRate;
    }
}
