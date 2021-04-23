package util;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public static Iterable<Integer> generateDataSet(int size, int minRandomRange, int maxRandomRange){
        ArrayList<Integer> dataSet = new ArrayList<>();
        for(int i = 0; i < size; i++){
            dataSet.add(ThreadLocalRandom.current().nextInt(minRandomRange, maxRandomRange + 1));
        }
        return dataSet;
    }
}
