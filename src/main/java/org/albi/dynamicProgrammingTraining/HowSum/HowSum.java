package org.albi.dynamicProgrammingTraining.HowSum;

import java.util.Collections;
import java.util.List;

//howSum takes in targetSum and an array of numbers as arguments
//should return an array containing any combination of elements
// that add up to exactly to targetSum else null
public class HowSum {
    public static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0 ) return List.of(targetSum);
        if (targetSum < 0) return Collections.emptyList();
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (!remainderResult.isEmpty()) {
                remainderResult.add(number);
                return remainderResult;
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] numbers1 = {2,3};
        int[] numbers10 = {5, 3, 4, 7};
        int[] numbers2 = {5, 3, 4, 5};
        int[] numbers3 = {5, 3, 4, 5};
        List<Integer> result = howSum(7, numbers1);
        System.out.println(result);
    }
}
