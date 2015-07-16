package com.lanfea.algorithm.sort;

import java.util.List;

/**
 * Created by lanfea on 2015/7/16.
 */
public abstract class Sorter<T extends Comparable<? super T>> {

    abstract void sort(T[] array);

    /**
     * 交换元素
     * @param array
     * @param i
     * @param j
     */
    protected void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
