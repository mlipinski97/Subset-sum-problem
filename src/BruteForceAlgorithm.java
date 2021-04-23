import java.util.ArrayList;
import java.util.List;

public class BruteForceAlgorithm {

    public Iterable<Integer> solve(Iterable<Integer> dataSet, Integer limit) {
        List<Integer> optimalSubset = new ArrayList<>();
        Integer foundMaxValue = 0;
        Integer tempSetValue;
        System.out.println("Original dataset: " + dataSet);
        List<List<Integer>> allSubsets = generateAllSubsets(dataSet);
        System.out.println("All subsets: " + allSubsets);
        for (List<Integer> subset : allSubsets) {
            tempSetValue = 0;
            for (Integer element : subset) {
                tempSetValue += element;
            }
            if (tempSetValue > foundMaxValue && tempSetValue <= limit) {
                foundMaxValue = tempSetValue;
                optimalSubset = subset;
            }
        }
        System.out.println("Optimal subset is: " + optimalSubset + " with value of: " + foundMaxValue);
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
            }
        }
        return allSubsets;
    }

}
