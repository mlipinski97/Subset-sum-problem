import static util.DataGenerator.generateDataSet;

public class Main {
    public static void main(String[] args) {
        BruteForceAlgorithm bfa = new BruteForceAlgorithm();
        bfa.solve(generateDataSet(4, 1, 1000), 670);
        bfa.solve(generateDataSet(6, 1, 1000), 670);
        bfa.solve(generateDataSet(8, 1, 1000), 670);
        bfa.solve(generateDataSet(10, 1, 1000), 670);
        bfa.solve(generateDataSet(20, 1, 1000), 670);
    }
}
