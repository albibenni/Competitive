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
        if (arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        Arrays.sort(arr);
        bucketNumbers(arr, listOfIntegers);

        int afterBucketSize = listOfIntegers.size();
        if (afterBucketSize == 0) return 0;
        if (afterBucketSize == 1) return 1;
        getBiggest(listOfIntegers, arr);

        return 0;
    }

    private int getBiggest(List<List<Integer>> listOfIntegers, int[] arr) {
        List<Integer> setValues = new ArrayList<>();
        int listSize = 0;
        for (int i = 0; i < listOfIntegers.size(); i++) {
            listSize += listOfIntegers.get(i).size();
            if (canHalveTheArrayOrMore(listSize, arr)) {
                setValues.add(listOfIntegers.get(i).get(0));
                break;
            }
        }
        return setValues.size();
    }

    private boolean canHalveTheArrayOrMore(int listSize, int[] arr) {
        return listSize >= arr.length;
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
                list = new ArrayList<>();
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
