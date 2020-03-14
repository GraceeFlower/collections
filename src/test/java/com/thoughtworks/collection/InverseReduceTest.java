package com.thoughtworks.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class InverseReduceTest {

    @Test
    public void should_be_divided_to_smaller_number() {
        InverseReduce inverseReduce = new InverseReduce();
        Integer[] result = new Integer[]{7, 5, 3, 1};
        List<Integer> resultList = Arrays.asList(result);
        assertThat(inverseReduce.divideToSmaller(9)).isEqualTo(resultList);
    }
}