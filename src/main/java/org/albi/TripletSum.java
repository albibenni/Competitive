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

@Builder
class Solution { // 15ms runtime ex
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int negC = 0, posC = 0, zeroC = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int v : nums) {
            if (v == 0) {
                zeroC++;
            } else if (v > 0) {
                posC++;
            } else {
                negC++;
            }
            if (v < min)
                min = v;
            if (v > max)
                max = v;
        }
        if (zeroC > 2)
            triplets.add(new Z(0, 0, 0));
        if (negC == 0 || posC == 0)
            return triplets;
        min = Math.max(min, -2 * max);
        max = Math.min(max, -2 * min);
        int[] negNums = new int[negC], posNums = new int[posC]; // distinct
        byte[] setC = new byte[max - min + 1]; // occurrences
        negC = 0;
        posC = 0;
        for (int v : nums) {
            int dif = v - min;
            if (dif >= 0 && v <= max && setC[dif] != 2 && setC[dif]++ == 0)
                if (v < 0) {
                    negNums[negC++] = v;
                } else if (v > 0) {
                    posNums[posC++] = v;
                }
        }

        Arrays.sort(negNums, 0, negC--);
        Arrays.sort(posNums, 0, posC--);
        if (posC < 0)
            return triplets;
        for (int i = 0; negC >= 0; negC--) {
            int a = negNums[negC];
            int na = -a;
            int posTo = Arrays.binarySearch(posNums, i, posC, na * 2);
            if (posTo < 0)
                posTo = Math.min(posC, ~posTo);
            i = Arrays.binarySearch(posNums, i, posC, na / 2);
            if (i < 0)
                i = ~i;
            for (int posI = posTo; posI >= i; posI--) {
                int c = posNums[posI];
                int b = na - c;
                if (b > c)
                    break;
                if (b >= a && setC[b - min] > 0 && (b != a || setC[a - min] > 1) && (b != c || setC[c - min] > 1))
                    triplets.add(new Z(a, b, c));

            }
        }
        return triplets;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {1, -1, -1, 0};
        List<List<Integer>> lists = Solution.builder().build().threeSum(nums);
        List<List<Integer>> lists2 = Solution.builder().build().threeSum(nums2);
        List<List<Integer>> lists3 = Solution.builder().build().threeSum(nums3);
        List<List<Integer>> lists4 = Solution.builder().build().threeSum(nums4);
        System.out.println(lists);
        System.out.println(lists2);
        System.out.println(lists3);
        System.out.println(lists4);
    }
}

class Z extends AbstractList<Integer> {
    int a, b, c;

    public Z(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Integer get(int i) {
        return i == 0 ? a : i == 1 ? b : c;
    }

    @Override
    public int size() {
        return 3;
    }
}
