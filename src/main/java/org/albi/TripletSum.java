package org.albi;

import lombok.Builder;

import java.util.*;

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
        int a;
        int b;
        int c;
        int numLength = nums.length;
        if (numLength < 3) return Collections.emptyList();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        if (numLength == 3) {
            a = nums[0];
            b = nums[1];
            c = nums[2];
            if (a+b+c == 0) {
                result.add(List.of(a, b, c));
            }
            return new ArrayList<>(result);
        }
        for (int i = 0; i < numLength - 2; i++) {
            a = nums[i];
            int j = i + 1;
            int k = numLength - 1;
            while (j < k) {
                int sum = a + nums[j] + nums[k];
                if (sum == 0) result.add(Arrays.asList(a, nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {1, -1, -1, 0};
        List<List<Integer>> lists = TripletSum.builder().build().threeSum(nums);
        List<List<Integer>> lists2 = TripletSum.builder().build().threeSum(nums2);
        List<List<Integer>> lists3 = TripletSum.builder().build().threeSum(nums3);
        List<List<Integer>> lists4 = TripletSum.builder().build().threeSum(nums4);
        System.out.println(lists);
        System.out.println(lists2);
        System.out.println(lists3);
        System.out.println(lists4);
    }
}
