package org.albi.adventOfCode.Day1;

/*

 */

import org.albi.adventOfCode.GetAdventData;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CalorieCounting {

    static final String str = GetAdventData.builder().build().getImputBasedOnYearAndDay(2022, 1);
    static final String[] part = str.split("(?=\\n\\n)|(?<=\\D)(?=\\d)");

    void findMax(String data) {
        int currentSum = 0;
        int spaces = 0;

    }

    public static void main(String[] args) {
        System.out.println(part[0]);
        System.out.println(part[1]);
        System.out.println(part[2]);
//        System.out.println(part[3]);
//        System.out.println(part[4]);
//        System.out.println(part[5]);
//        System.out.println(part[6]);
//        System.out.println(part[7]);
//        System.out.println(part[8]);
//        System.out.println(part[9]);
//        System.out.println(part[10]);
//        System.out.println(part[11]);
//        System.out.println(part[10]);
        System.out.println(Arrays.stream(part).count());
    }
}


