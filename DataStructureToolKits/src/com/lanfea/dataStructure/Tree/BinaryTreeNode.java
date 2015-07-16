package com.lanfea.dataStructure.tree;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeNode<T> {

    public T value;
    public BinaryTreeNode<T> leftChild;
    public BinaryTreeNode<T> rightChild;
    // 供非递归后序遍历使用
    public boolean isFirst;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
