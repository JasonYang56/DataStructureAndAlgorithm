package com.atguigu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{4,0,2,1,3};
        List<Integer> ints = new ArrayList(Arrays.asList(nums));
        ints.sort(Comparator.naturalOrder());
        System.out.println(Arrays.toString(ints.toArray()));
    }
}
