package org.albi.dynamicProgrammingTraining.HowSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//howSum takes in targetSum and an array of numbers as arguments
//should return an array containing any combination of elements
// that add up to exactly to targetSum else null
public class HowSum {
    public static int[] howSum(int targetSum, int[] numbers) {
//        List<Integer> remainderResult = new ArrayList<>();
        if (targetSum == 0) return new int[0];
        if (targetSum < 0) return null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            int[] remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
//                remainderResult.add(number);
                return remainderResult;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 3};
        int[] numbers10 = {5, 3, 4, 7};
        int[] numbers2 = {5, 3, 4, 5};
        int[] numbers3 = {5, 3, 4, 5};
        int[] result = howSum(7, numbers1);
        assert result != null;
        Arrays.stream(result).forEach(System.out::println);
    }
}
