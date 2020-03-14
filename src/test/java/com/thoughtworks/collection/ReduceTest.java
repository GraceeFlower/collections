package com.thoughtworks.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ReduceTest {

    @Test
    public void should_get_maximum_of_list() {
        // 获取数组中的最大值
        Integer[] array = new Integer[]{1, 5, 7, 2, 8, 9, 3, 2};
        List<Integer> arrayList = Arrays.asList(array);

        Reduce reduce = new Reduce(arrayList);

        assertThat(reduce.getMaximum()).isEqualTo(9);
    }

    @Test
    public void should_get_minimum_of_list() {
        //获取数组中的最小值
        Integer[] array = new Integer[]{9, 4, 5, 10, 34, 2, 1, 10, 16};
        List<Integer> arrayList = Arrays.asList(array);

        Reduce reduce = new Reduce(arrayList);

        assertThat(reduce.getMinimum()).isEqualTo(1);
    }

    @Test
    public void should_get_average_of_list() {
        // 获取数组的平均值
        Integer[] array = new Integer[]{12, 34, 56, 78, 90, 21};
        List<Integer> arrayList = Arrays.asList(array);

        Reduce reduce = new Reduce(arrayList);

        assertThat(reduce.getAverage()).isEqualTo(48.5);
    }

    @Test
    public void should_return_first_even_element() {
        //获取数组中第一个偶数
        Integer[] array = new Integer[]{1, 11, 27, 20, 4, 9, 15};
        List<Integer> arrayList = Arrays.asList(array);

        Reduce reduce = new Reduce(arrayList);
        assertThat(reduce.getFirstEven()).isEqualTo(20);
    }
}