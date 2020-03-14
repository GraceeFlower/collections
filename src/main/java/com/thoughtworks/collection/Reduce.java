package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num -> num % 2 == 0).findFirst().orElse(0);
    }

    public double getOrderedMedian() {
        int len = arrayList.size();
        arrayList = arrayList.stream().sorted().collect(Collectors.toList());
        if (len % 2 == 0) {
            return (double) (arrayList.get(len / 2 - 1) + arrayList.get(len / 2)) / 2;
        } else {
            return (double) arrayList.get(len / 2);
        }
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream().filter(num -> num % 2 == 0).findFirst().orElse(0));
    }

    public int getLastOdd() {
        arrayList = arrayList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        return arrayList.get(arrayList.size() - 1);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.size() == arrayList.size()
            && this.arrayList.stream().anyMatch(arrayList::contains);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddArr = arrayList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        return arrayList.lastIndexOf(oddArr.get(oddArr.size() - 1));
    }

}