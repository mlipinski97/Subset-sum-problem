import java.util.ArrayList;
import java.util.List;

public class BruteForceAlgorithm {

    public static int numberOfOperations = 0;
    public static int biggestCollectionSize = 0;

    public Iterable<Integer> solve(Iterable<Integer> dataSet, Integer limit) {
        biggestCollectionSize = 0;
        numberOfOperations = 0;
        dataSet.forEach(integer -> biggestCollectionSize++);
        List<Integer> optimalSubset = new ArrayList<>();
        Integer foundMaxValue = 0;
        Integer tempSetValue;
        System.out.println("Original dataset: " + dataSet);
        List<List<Integer>> allSubsets = generateAllSubsets(dataSet);
        /*System.out.println("All subsets: " + allSubsets);*/
        for (List<Integer> subset : allSubsets) {
            tempSetValue = 0;
            numberOfOperations++;
            for (Integer element : subset) {
                tempSetValue += element;
                numberOfOperations++;
            }
            if (tempSetValue > foundMaxValue && tempSetValue <= limit) {
                foundMaxValue = tempSetValue;
                optimalSubset = subset;
            }
        }
        System.out.println("Optimal subset is: " + optimalSubset + " with value of: " + foundMaxValue);
        System.out.println("number of operations done: " + BruteForceAlgorithm.numberOfOperations);
        System.out.println("size of biggest dataset equals: " + BruteForceAlgorithm.biggestCollectionSize
                + "\narrays holding datasets are made of Integer type which is size of: " + Integer.BYTES
                + " bytes. that makes max array size of: " + Integer.BYTES*BruteForceAlgorithm.biggestCollectionSize
                + " Bytes which is: " + Integer.BYTES*BruteForceAlgorithm.biggestCollectionSize*8 + " bits");
        return optimalSubset;
    }

    private List<List<Integer>> generateAllSubsets(Iterable<Integer> original) {
        List<List<Integer>> allSubsets = new ArrayList<>();

        allSubsets.add(new ArrayList<Integer>()); //Add empty set.

        for (Integer element : original) {
            List<List<Integer>> tempClone = new ArrayList<>(allSubsets);
            for (List<Integer> subset : tempClone) {
                List<Integer> extended = new ArrayList<Integer>(subset);
                extended.add(element);
                allSubsets.add(extended);
                numberOfOperations++;
                if (extended.size() > numberOfOperations) {
                    numberOfOperations = extended.size();
                }
            }
        }
        return allSubsets;
    }

}
