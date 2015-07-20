package com.lanfea.algorithm.sort;

/**
 * Created by lanfea on 2015/7/20.
 * 堆排序，时间复杂度O(log2n)，空间复杂度O(1)
 */
public class HeapSorter<T extends Comparable<? super T>> extends Sorter<T>{

    // 标志位，判断是构建大根堆还是小根堆
    private static boolean isMaxHeap = true;

    public HeapSorter(boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
    }

    @Override
    void sort(T[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return;
        if (isMaxHeap) {
            buildHeap(array, array.length - 1, true);
            // 每次将大根堆的根元素与最后一个叶结点交换，之后的调整长度-1
            for (int i = array.length - 1; i > 0; i--) {
                swap(array, 0, i);
                adjustDown(array, 0, i - 1, true);
            }
        } else {
            buildHeap(array, array.length - 1, false);
            // 每次将小根堆的根元素与最后一个叶结点交换，之后的调整长度-1
            for (int i = array.length - 1; i > 0; i--) {
                swap(array, 0, i);
                adjustDown(array, 0, i - 1, false);
            }
        }
    }

    /**
     * 根据isMaxHeap参数建立大根堆或小根堆
     * @param array
     * @param length
     * @param isMaxHeap
     */
    private void buildHeap(T array[], int length, boolean isMaxHeap) {
        for (int i = length / 2; i >= 0; i--) {
            adjustDown(array, i, length, isMaxHeap);
        }
    }

    /**
     * 从array[key]向下调整
     * @param array
     * @param key
     * @param length
     * @param isMaxHeap
     */
    private void adjustDown(T[] array, int key, int length, boolean isMaxHeap) {
        // array[0]暂存
        T keyValue = array[key];
        // 沿着key较大的子节点向下筛选，如果是小根堆则沿着key较小的子节点
        for (int i = 2*key + 1; i <= length; i = i*2 + 1) {
            // 取子节点的下标
            if (isMaxHeap) {
                if (i < length && array[i].compareTo(array[i+1]) < 0)
                    i ++;
                // 子节点都没有key节点大，筛选结束
                if (keyValue.compareTo(array[i]) >= 0)
                    break;
            } else {
                if (i < length && array[i].compareTo(array[i+1]) > 0)
                    i ++;
                // 子节点都没有key节点小，筛选结束
                if (keyValue.compareTo(array[i]) <= 0)
                    break;
            }
            // 将array[i]调整到双亲节点上
            array[key] = array[i];
            // 修改key的值，以便继续向下筛选
            key = i;
        }// end for
        // 被筛选节点的值放入最终位置
        array[key] = keyValue;
    }
}
