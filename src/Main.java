import static util.DataGenerator.generateDataSet;

public class Main {

    public static void main(String[] args) {
        BruteForceAlgorithm bfa = new BruteForceAlgorithm();
        bfa.solve(generateDataSet(4, 1, 10), 10);
    }

}
