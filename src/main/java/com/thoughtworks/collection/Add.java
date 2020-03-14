package com.thoughtworks.collection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int left = Math.min(leftBorder, rightBorder);
        int right = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(left, right)
            .filter(num -> num % 2 == 0)
            .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int left = Math.min(leftBorder, rightBorder);
        int right = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(left, right)
            .filter(num -> num % 2 != 0)
            .sum();
        // IntStream 可以直接用 sum，还有一个 range 方法！
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
            .map(num -> num * 3 + 2)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
            .map(num -> num % 2 != 0 ? num * 3 + 2 : num)
            .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 != 0)
            .map(num -> num * 3 + 5)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        arrayList = arrayList.stream().filter(num -> num % 2 == 0)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
        int len = arrayList.size();
        if (len % 2 == 0) {
            return (double) (arrayList.get(len / 2 - 1) + arrayList.get(len / 2)) / 2;
        } else {
            return (double) arrayList.get(len / 2);
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
            .filter(num -> num % 2 == 0)
            .mapToInt(Integer::intValue)
            .average().orElse(0);
//        arrayList = arrayList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
//        return (double) arrayList.stream().reduce(Integer::sum).orElse(0) / arrayList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
            .anyMatch(num -> num % 2 == 0 && num.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
            .filter(num -> num % 2 == 0)
            .distinct().collect(Collectors.toList());
    }
}
