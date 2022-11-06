package org.albi;

import lombok.Builder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class ReduceIntegerArray {
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
        return getBiggest(listOfIntegers, arrLength / 2);
    }

    private int getBiggest(List<List<Integer>> listOfIntegers, int halfLengthArr) {
        int listSize = 0;
        int returnValue = 0;
        List<Integer> setValues = new ArrayList<>();
        for (List<Integer> listOfInteger : listOfIntegers) {
            listSize += listOfInteger.size();
            Integer presentValue = listOfInteger.get(0);
            setValues.add(presentValue);
            int actualSize = setValues.size();
            if (canHalveTheArrayOrMore(listSize, halfLengthArr)) {
                listSize = 0;
                if (actualSize < returnValue) returnValue = actualSize;
                setValues = new ArrayList<>();
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
                if (i == arr.length - 1)
                    listOfIntegers.add(list);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {
                3, 3, 3, 3, 5, 5, 5, 2, 2, 7
        };
        ReduceIntegerArray reduceIntegerArray = ReduceIntegerArray.builder().build();
        System.out.println(reduceIntegerArray.minSetSize(arr));

    }
}
