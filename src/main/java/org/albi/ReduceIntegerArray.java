package org.albi;

import lombok.Builder;

import java.util.*;

@Builder
public class ReduceIntegerArray implements Comparator<List<Integer>> {
    public int minSetSize(int[] arr) {
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        int arrLength = arr.length;
        if (arrLength == 0) return 0;
        if (arrLength == 1) return 1;
        Arrays.sort(arr);
        bucketNumbers(arr, listOfIntegers);

        int afterBucketSize = listOfIntegers.size();
        if (afterBucketSize == 0) return 0;
        if (afterBucketSize == 1) return 1;
        Collections.sort(listOfIntegers, this::compare);
        return getMinNumbOfIntegers(listOfIntegers, arrLength / 2);
    }


    private int getMinNumbOfIntegers(List<List<Integer>> listOfIntegers, int halfLengthArr) {
        int listSize = 0;
        int returnValue = halfLengthArr;
        int currentValuesConsidered = 1;
        int valuesAdded = 0;
        int listOfIntegersSize = listOfIntegers.size();
        if (canHalveTheArrayOrMore(listOfIntegers.get(listOfIntegersSize-1).size(), halfLengthArr)) {
            if (currentValuesConsidered <= returnValue) return 1;
        }
        for (int i = listOfIntegersSize - 1; i >= 0; i--) {
            int firstConsideredSize = listOfIntegers.get(i).size();
            listSize = firstConsideredSize;
            for (int j = i - 1; j >= 0; j--) {
                listSize += listOfIntegers.get(j).size();
                valuesAdded++;
                if (canHalveTheArrayOrMore(listSize, halfLengthArr)) {
                    currentValuesConsidered += valuesAdded;
                    if (currentValuesConsidered < returnValue) {
                        returnValue = currentValuesConsidered;
                    }
                    valuesAdded = 0;
                    currentValuesConsidered = 1;
                    listSize = firstConsideredSize;
                }

            }

        }
        return returnValue;
    }

    private boolean canHalveTheArrayOrMore(int listSize, int halfLengthArr) {
        return halfLengthArr <= listSize;
    }

    private static void bucketNumbers(int[] arr, List<List<Integer>> listOfIntegers) {
        int selectedNumb = arr[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int iInt = arr[i];
            if (selectedNumb == iInt) {
                list.add(iInt);
            } else {
                listOfIntegers.add(list);
                selectedNumb = iInt;
                list = new ArrayList<>();
                list.add(iInt);
            }
            if (i == arr.length - 1) listOfIntegers.add(list);
        }
    }

    @Override
    public int compare(List<Integer> l1, List<Integer> l2) {
        return Integer.compare(l1.size(), l2.size());
    }

    public static void main(String[] args) {
        int[] arr = {
                3, 3, 3, 3, 5, 5, 5, 2, 2, 7
        };
        int[] arr3 = {
                9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19
        };
        int[] arr2 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        int[] arr4 = {
                7, 7, 7, 7, 7, 7
        };
        ReduceIntegerArray reduceIntegerArray = ReduceIntegerArray.builder().build();
//        System.out.println(reduceIntegerArray.minSetSize(arr));
        System.out.println(reduceIntegerArray.minSetSize(arr2));

    }


}
