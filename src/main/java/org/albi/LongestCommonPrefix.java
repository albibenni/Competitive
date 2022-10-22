package org.albi;

import lombok.Builder;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Builder
@Generated
@RequiredArgsConstructor
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {


        return "";
    }

//    private List<Character> commonPrefixs (String[] strs, int strIndex){
//        if (strIndex >= strs.length) return Collections.emptyList();
//        String str0 = strs[strIndex];
//        String str1 = strs[strIndex+1];
//        return IntStream.of(0, str0.length())
//                .filter(index -> str0.charAt(index) == str1.charAt(index))
//                .mapToObj(number -> (char)number)
//                .toList();
//    }

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        String [] strs2 = {"dog","racecar","car"};
        LongestCommonPrefix longestCommonPrefix = LongestCommonPrefix.builder().build();
        String str0 = strs[0];
        String str1 = strs[1];
//        List<Character> characters = IntStream.range(0, str0.length())
//                .filter(index -> str0.charAt(index) == str1.charAt(index))
//                .mapToObj(number -> (char)number)
//                .collect(Collectors.toList());

        List<Character> characters = IntStream.range(0, str0.length())
                .filter(i -> i < str1.length())
                .filter(index -> str0.charAt(index) == str1.charAt(index))
                .mapToObj(number -> (char) number)
                .toList();
//        String characters2 = IntStream.range(0, strs.length)
//                .filter(i -> strs[i].length() <= 5)
//                .mapToObj(i -> strs[i])
//                .toList().toString();

//        System.out.println(longestCommonPrefix.commonPrefixs(strs,0).toString());
//        System.out.println(characterStream);
        System.out.println(characters);
//        System.out.println(longestCommonPrefix.commonPrefixs(strs2,0).toString());
    }
}
