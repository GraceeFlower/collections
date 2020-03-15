package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(num -> num * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(num -> letters[num - 1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(this::getLetter).collect(Collectors.toList());
    }

    private String getLetter(int num) {
        int excess = (int) Math.floor((num - 1) / 26.0);
        int letter = num - excess * 26;
        return (0 == excess ? letters[num - 1] : letters[excess - 1] + letters[letter - 1]);
//        if (num <= 26) {
//            return letters[num - 1];
//        } else if (num % 26 == 0) {
//            return letters[(num - 1) / 26 - 1] + getLetter(26);
//        }
//        return letters[num / 26 - 1] + getLetter(num % 26);
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
