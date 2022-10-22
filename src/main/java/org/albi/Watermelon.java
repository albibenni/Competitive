package org.albi;


import javafx.util.Pair;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

@Builder
@Generated
@RequiredArgsConstructor
public class Watermelon {
    private final int weight;

    public Pair<Integer, Integer> getWatermelonDivisionWeight() {
        int result = calculateWatermelonLowestDivisor();
        return new Pair<>(result, weight - result);
    }

    private int calculateWatermelonLowestDivisor() {
        OptionalInt result = lowerNumbers().stream()
                .filter(numb -> weight % numb == 0)
                .toList()
                .stream()
                .mapToInt(i -> i)
                .max();
        if (result.isPresent()) return result.getAsInt();
        return weight;
    }

    private List<Integer> lowerNumbers() {
        List<Integer> results = new ArrayList<>();
        if (weight == 1) {
            results.add(weight);
            return results;
        }
        for (int i = 2; i <= weight / 2; i++) {
            results.add(i);
        }
        return results;
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> pair = Watermelon.builder().weight(10).build().getWatermelonDivisionWeight();
        System.out.println("first: " + pair.getKey());
        System.out.println("second: " + pair.getValue());
    }
}
