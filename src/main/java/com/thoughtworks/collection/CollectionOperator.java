package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return left < right ?
        IntStream.rangeClosed(left, right)
            .boxed()
            .collect(Collectors.toList()) :
            IntStream.rangeClosed(right, left)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return left < right ?
            IntStream.rangeClosed(left, right)
                .boxed()
                .filter(num -> 0 == num % 2)
                .collect(Collectors.toList()) :
            IntStream.rangeClosed(right, left)
                .boxed()
                .filter(num -> 0 == num % 2)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElements(int[] array) {
//        return Stream.of(array)
//            .filter(num -> 0 == num % 2)
//            .collect(Collectors.toList());
//      优雅地将int[] -> Integer
        return IntStream.of(array).boxed()
            .filter(num -> 0 == num % 2)
            .collect(Collectors.toList());
    }

    public int popLastElement(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = IntStream.of(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondList = IntStream.of(secondArray).boxed().collect(Collectors.toList());
        firstList.retainAll(secondList);
        return firstList;
//        IntStream.of(firstArray).boxed()
//            .filter(IntStream.of(secondArray)
//                .boxed()
//                .collect(Collectors.toList())::contains)
//            .collect(Collectors.toList())
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
//        虽然题目意思理解错了 但是这个UnsupportedOperationException异常第一次发现，是由直接Arrays.asList(arr)引起的
//        源码中该转换继承了父类的异常，没有重写add和remove方法，需要改成下面这样。
//        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
//        List<Integer> secondList = new ArrayList<>(Arrays.asList(secondArray));
//        List<Integer> eleList = new ArrayList<>(secondList);
//        eleList.addAll(firstList);
//        firstList.retainAll(secondList);
//        return eleList.stream().filter(num -> !firstList.contains(num)).collect(Collectors.toList());
        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(secondArray));
        firstList.addAll(secondList.stream()
            .filter(num -> !firstList.contains(num))
            .collect(Collectors.toList()));
        return firstList;
    }
}
