package com.lanfea.algorithm.sort;

import java.util.List;

/**
 * Created by lanfea on 2015/7/16.
 * 插入排序，时间复杂度O(n*n)，空间复杂度O(1)，稳定
 */
public class InsertSorter<T extends Comparable<? super T>> extends Sorter<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length == 1)
            return;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T key = array[i];
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = key;
        }
    }
}
