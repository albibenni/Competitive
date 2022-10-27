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
        if (nums.length == 3) {
            List<Integer> integers = tripletSumEqualZero(nums[0], nums[1], nums[2], Collections.emptyList());
            if (integers == null) return Collections.emptyList();
            return List.of(integers);
        }
        List<List<Integer>> result = new ArrayList<>();
        int i, j, k, a, b, c;
        for (i = 0; i < nums.length - 2; i++) {
            a = nums[i];
            for (j = i + 1; j < nums.length - 1; j++) {
                b = nums[j];
                for (k = j + 1; k < nums.length; k++) {
                    c = nums[k];
                    List<Integer> integers = tripletSumEqualZero(a, b, c, result);
                    if (integers == null) continue;
                    result.add(integers);
                }
            }
        }
        if (result.size() == 0) return Collections.emptyList();

        return result;
    }

    private List<Integer> tripletSumEqualZero(int a, int b, int c, List<List<Integer>> tripletsAlreadyIn) {
        int sum = a + b + c;
        if (sum == 0 && !isADuplicateTriplets(a, b, c, tripletsAlreadyIn)) {
            List<Integer> resutlList = new ArrayList<>();
            resutlList.add(a);
            resutlList.add(b);
            resutlList.add(c);
            return resutlList;
        }
        return null;
    }

    private boolean isADuplicateTriplets(int a, int b, int c, List<List<Integer>> checkTriplets) {
        for (List<Integer> checkTriplet : checkTriplets) {
            List<Integer> intArr = new ArrayList<>();
            intArr.add(a);
            intArr.add(b);
            intArr.add(c);
            for (int j = 0; j < 3; j++) {
                int compareNumb = checkTriplet.get(j);
                for (int k = 0; k < intArr.size(); k++) {
                    if (compareNumb == intArr.get(k)) {
                        intArr.remove(k);
                        break;
                    }
                }
            }
            if (intArr.size()==0) return true;
        }
        return false;
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
