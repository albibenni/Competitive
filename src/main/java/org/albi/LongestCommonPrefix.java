package org.albi;

import lombok.Builder;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@Builder
@Generated
@RequiredArgsConstructor
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"ab", "a"};
        String[] strs4 = {"abab","aba",""};
        LongestCommonPrefix commonPrefix = LongestCommonPrefix.builder().build();
        String s3 = commonPrefix.longestCommonPrefix(strs3);
        String s = commonPrefix.longestCommonPrefix(strs);
        String s2 = commonPrefix.longestCommonPrefix(strs2);
        String s4 = commonPrefix.longestCommonPrefix(strs4);
        System.out.println(s);
        System.out.println("S2: " + s2);
        System.out.println("S3: " + s3);
        System.out.println("S4: " + s4);
    }
}
