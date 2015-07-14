package com.lanfea.dataStructure.Tree;

import java.util.Stack;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeTraverser {

    public interface Callback<T> {
        void visit(BinaryTreeNode<T> node);
    }

    private BinaryTreeTraverser() {

    }
    public static BinaryTreeTraverser getInstance() {
        return Nested.instance;
    }
    static class Nested {
        private static BinaryTreeTraverser instance = new BinaryTreeTraverser();
    }

    /**
     * 二叉树的先序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void preOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        callback.visit(root);
        preOrderTraverse(root.leftChild,callback);
        preOrderTraverse(root.rightChild,callback);
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void inOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.leftChild, callback);
        callback.visit(root);
        inOrderTraverse(root.rightChild, callback);
    }

    /**
     * 二叉树的后序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void postOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.leftChild, callback);
        postOrderTraverse(root.rightChild, callback);
        callback.visit(root);
    }

    /**
     * 二叉树非递归先序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void nonRecursivePreOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        BinaryTreeNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                callback.visit(node);
                stack.push(node);
                node = node.leftChild;
            }
            else {
                node = stack.pop().rightChild;
            }
        }
    }

    /**
     * 二叉树非递归中序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void nonRecursiveInOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        BinaryTreeNode<T> node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            else {
                node = stack.pop();
                callback.visit(node);
                node = node.rightChild;
            }
        }
    }

    /**
     * 二叉树非递归后序遍历
     * @param root
     * @param callback
     * @param <T>
     */
    public <T> void nonRecursivePostOrderTraverse(BinaryTreeNode<T> root, Callback callback) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        BinaryTreeNode<T> node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                node.isFirst = true;
                stack.push(node);
                node = node.leftChild;
            }
            else {
                node = stack.pop();
                if (node.isFirst) {
                    node.isFirst = false;
                    stack.push(node);
                    node = node.rightChild;
                } else {
                    callback.visit(node);
                    node = null;
                }
            }
        }
    }
}
