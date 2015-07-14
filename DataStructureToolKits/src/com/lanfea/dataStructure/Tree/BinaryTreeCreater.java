package com.lanfea.dataStructure.Tree;

import java.util.ArrayList;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeCreater {

    private BinaryTreeCreater() {

    }
    public static BinaryTreeCreater getInstance() {
        return Nested.instance;
    }
    static class Nested {
        private static BinaryTreeCreater instance = new BinaryTreeCreater();
    }

    /**
     * 利用数组构造二叉树
     * @param array
     * @param <T>
     * @return
     */
    public <T> BinaryTreeNode<T> constructBinaryTree(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ArrayList<BinaryTreeNode<T>> nodeArrayList = new ArrayList<BinaryTreeNode<T>>();
        for (T value : array) {
            BinaryTreeNode<T> node = new BinaryTreeNode<T>(value);
            nodeArrayList.add(node);
        }
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex ++) {
            BinaryTreeNode<T> currentParent = nodeArrayList.get(parentIndex);
            // 左子结点在列表中的位置
            int leftChildIndex = parentIndex * 2 + 1;
            // 右子节点在列表中的位置
            int rightChildIndex = parentIndex * 2 + 2;
            currentParent.leftChild = nodeArrayList.get(leftChildIndex);
            currentParent.rightChild = nodeArrayList.get(rightChildIndex);
        }
        // 最后一个父节点可能没有右子节点，所以要单独来处理
        int lastParentIndex = array.length / 2 - 1;
        BinaryTreeNode<T> lastParent = nodeArrayList.get(lastParentIndex);
        lastParent.leftChild = nodeArrayList.get(lastParentIndex * 2 + 1);
        // 数组长度为奇数时，才有右子节点
        if (array.length % 2 == 1) {
            lastParent.rightChild = nodeArrayList.get(lastParentIndex * 2 + 2);
        }
        // 返回二叉树的根节点
        return nodeArrayList.get(0);
    }
}
