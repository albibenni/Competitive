package org.albi;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Builder
public class TripletSum {

    /* Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
    */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i, j, z, a, b, c, iLength, jLength;
        int numLength = nums.length;
        iLength = (numLength / 3);
        jLength = iLength * 2;
        if (nums.length == 3) {
            a = nums[0];
            b = nums[1];
            c = nums[2];
            if (tripletSumEqualZero(a, b, c)) {
                result.add(List.of(a, b, c));
            }
            return result;
        }
        for (i = 0; i < iLength; i++) {
            a = nums[i];
            for (j = iLength; j < jLength; j++) {
                b = nums[j];
                for (z = jLength; z < numLength; z++) {
                    c = nums[z];
                    if (tripletSumEqualZero(a, b, c)) {
                        result.add(List.of(a, b, c));
                    }
                }
            }
        }
        return checkTripletsDuplicate(result);
    }

    private boolean tripletSumEqualZero(int a, int b, int c) {
        return a + b + c == 0;
    }

    private List<List<Integer>> checkTripletsDuplicate (List<List<Integer>> checkTriplets) {
        for (int listIndex = 0; listIndex < checkTriplets.size(); listIndex++) {
            for (int nextIndex = listIndex; nextIndex < checkTriplets.size(); nextIndex++) {
                if (checkTriplets.get(listIndex).equals(checkTriplets.get(nextIndex))){
                    checkTriplets.remove(nextIndex);
                }
            }
        }

        return checkTriplets;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> lists = TripletSum.builder().build().threeSum(nums);
        List<List<Integer>> lists2 = TripletSum.builder().build().threeSum(nums2);
        List<List<Integer>> lists3 = TripletSum.builder().build().threeSum(nums3);
        System.out.println(lists);
        System.out.println(lists2);
        System.out.println(lists3);
    }
}
