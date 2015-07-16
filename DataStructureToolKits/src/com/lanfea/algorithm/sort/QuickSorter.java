package com.lanfea.algorithm.sort;

/**
 * Created by lanfea on 2015/7/16.
 * 快速排序，使用插入排序、三数取中、聚集重复元素方法对快排进行了优化。
 */
public class QuickSorter<T extends Comparable<? super T>> extends Sorter<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length == 1)
            return;
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     * @param array
     * @param low
     * @param high
     */
    private void quickSort(T[] array, int low, int high) {
        // 记录数组的开始和结束位置
        int first = low;
        int last = high;
        // 记录与pivot重复的元素在左侧结束的索引和在右侧开始的索引
        int left = low;
        int right = high;
        // 记录与pivot重复的元素在左侧聚集的长度和在右侧聚集的长度
        int leftLen = 0;
        int rightLen = 0;
        // 如果数组长度分割到一定程度时可以使用插排
        InsertSorter insertSorter = new InsertSorter();
        if (high - low + 1 < 10) {
            insertSorter.sort(array);
            return;
        }
        T pivot = selectPivot(array, low, high);
        while (low < high) {
            while (low < high && array[high].compareTo(pivot) >= 0) {
                // 将与pivot相同的元素都聚集到数组右侧
                if (array[high].compareTo(pivot) == 0) {
                    swap(array, right, high);
                    right --;
                    rightLen ++;
                }
                high --;
            }
            array[low] = array[high];
            while (low < high && array[low].compareTo(pivot) <= 0) {
                // 将与pivot相同的元素都聚集到数组左侧
                if (array[low].compareTo(pivot) == 0) {
                    swap(array, left, low);
                    left ++;
                    rightLen ++;
                }
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        // 一次快排结束，将与pivot相等的值都移动到pivot所在位置周围
        int i = low - 1;
        int j = first;
        while (j < left && array[i] != pivot) {
            swap(array, i, j);
            i --;
            j ++;
        }
        i = low + 1;
        j = last;
        while (j > right && array[i] != pivot) {
            swap(array, i, j);
            i ++;
            j --;
        }
        // 继续递归，重复的元素不用再考虑
        quickSort(array, first, low - 1 - leftLen);
        quickSort(array, low + 1 + rightLen, last);
    }

    /**
     * 选取基准值
     * @param array
     * @param low
     * @param high
     * @return
     */
    private T selectPivot(T[] array, int low, int high) {
        // 右移一位相当于除2且效率更高
        int mid = low + ((high-low) >> 1);
        // 使用三数取中法选择pivot
        if (array[mid].compareTo(array[high]) > 0)
            swap(array, mid, high);
        if (array[low].compareTo(array[high]) > 0)
            swap(array, low, high);
        if (array[mid].compareTo(array[low]) > 0)
            swap(array, low, mid);
        // 最后array[low]存放的就是中值
        return array[low];
    }

}
