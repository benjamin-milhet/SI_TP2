import Configuration.Config;
import Population.Population;

public class TP2 {
    public static void main(String[] args) {
        // Configures the genetic algorithm
        Config.createConfig(500, 35, 1, 300, 0.01);

        // Creates the initial population
        Population currentPopulation = new Population(true);
        System.out.println(currentPopulation.findBestIndividual());

        // Loops for all generations to be generated
        for(int generationNumber=0; generationNumber<Config.getNumberOfGenerations(); generationNumber++) {
            currentPopulation = currentPopulation.computeNextGeneration();
            System.out.println(currentPopulation.findBestIndividual());
        }
    }
}
