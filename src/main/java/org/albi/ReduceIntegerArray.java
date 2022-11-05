package org.albi;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceIntegerArray {
    public int minSetSize(int[] arr) {
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        if (arr.length == 0) return 0;
        if (arr.length== 1)return 1;
        Arrays.sort(arr);
        bucketNumbers(arr, listOfIntegers);

        int afterBucketSize = listOfIntegers.size();
        if (afterBucketSize == 0) return 0;
        if (afterBucketSize == 1) return 1;
        if (afterBucketSize > 1){
            canHalveOrMore(listOfIntegers);
        }

        return 0;
    }

    private void canHalveOrMore(List<List<Integer>> listOfIntegers) {
        int max = 0;
        int lessMax = 0;
        int listMaxIndex = 0;
        int listLessMaxIndex = 0;
        for (int i = 0; i < listOfIntegers.size(); i++) {
            int listSize = listOfIntegers.get(i).size();
            if (max == 0) {
                lessMax = max;
                max = listSize;
                listLessMaxIndex = listMaxIndex;
                listMaxIndex = i;
            } else {
                if (max < listSize) {

                    max = listSize;
                }
            }
        }
    }

    private static void bucketNumbers(int[] arr, List<List<Integer>> listOfIntegers) {
        int selectedNumb = arr[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int iInt = arr[i];
            if (selectedNumb == iInt){
                list.add(iInt);
            }
            else {
                listOfIntegers.add(list);
                list = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {

    }
}
