package com.thoughtworks.collection;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    public InverseReduce() {
    }

    public List<Integer> divideToSmaller(int number) {
        return IntStream.range(0, number).boxed()
            .filter(num -> num % 2 != 0)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
