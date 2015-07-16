package com.lanfea.algorithm.sort;

/**
 * Created by lanfea on 2015/7/16.
 * 冒泡排序，时间复杂度O(n*n)，空间复杂度O(1)，稳定
 */
public class BubbleSorter<T extends Comparable<? super T>> extends Sorter<T>{
    @Override
    public void sort(T[] array) {
        if (array == null || array.length == 1)
            return;
        // 在一次冒泡过程中是否发生过交换
        boolean flag;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    swap(array, j - 1, j);
                    flag = true;
                }
            }
            // 没有发生过交换，说明已经有序，算法直接返回
            if (!flag)
                return;
        }
    }

}
