package com.lanfea.algorithm.sort;

import com.lanfea.util.generator.Generated;
import com.lanfea.util.generator.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by lanfea on 2015/7/16.
 */
public class SortTester {

    public static void main(String[] args) {
        Sorter<Integer> sorter1 = new InsertSorter<Integer>();
        Sorter<Integer> sorter2 = new BubbleSorter<Integer>();
        Sorter<Integer> sorter3 = new QuickSorter<Integer>();
        Integer[] a = Generated.array(Integer.class, new RandomGenerator.Integer(), 10);
        sorter3.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
