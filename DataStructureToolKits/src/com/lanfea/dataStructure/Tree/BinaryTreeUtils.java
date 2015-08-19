package com.lanfea.dataStructure.Tree;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeUtils {

    /*------------------------------Question1------------------------------*/
    private static BinaryTreeNode previousTreeNode;

    /**
     * 获取二叉树转换为对应双向链表的头节点
     * @param currentNode
     * @param <T>
     * @return
     */
    public static <T> BinaryTreeNode<T> binaryTreeToLinkedList(BinaryTreeNode<T> currentNode) {
        // 转换之后，currentNode为双向链表中对应二叉树根节点的链表节点
        convertToLinkedList(currentNode);
        while(currentNode != null && currentNode.leftChild != null) {
            currentNode = currentNode.leftChild;
        }
        return currentNode;
    }

    /**
     * 将二叉树转化为双向链表,就是中序遍历的思想
     * @param currentNode
     * @param <T>
     * @return
     */
    private static <T> void convertToLinkedList(BinaryTreeNode<T> currentNode) {
        if (currentNode == null)
            return;
        // 先遍历左子树
        convertToLinkedList(currentNode.leftChild);
        // 访问根节点，建立双向连接
        if (previousTreeNode != null) {
            currentNode.leftChild = previousTreeNode;
            previousTreeNode.rightChild = currentNode;
        }
        previousTreeNode = currentNode;
        // 再遍历右子树
        convertToLinkedList(currentNode.rightChild);
    }
    /*------------------------------EndOfQuestion1------------------------------*/

    /*------------------------------Question2------------------------------*/
    private static List<String> resultList = new CopyOnWriteArrayList<String>();

    /**
     * 寻找二叉树中和为某一值的路径，路径为从根节点到任一子节点
     * @param root
     * @param expectedSum
     * @return
     */
    public static List<String> findPath(BinaryTreeNode<Integer> root, int expectedSum) {
        if (root == null)
            return null;
        // 用来存储路径上访问过的节点
        Stack<Integer> pathStack = new Stack<Integer>();
        // 用来存储当前当前遍历过节点值的和
        int currentSum = 0;
        findPath(root, expectedSum, pathStack, currentSum);
        return resultList;
    }

    /**
     * 实际寻径函数
     * @param root
     * @param expectedSum
     * @param pathStack
     * @param currentSum
     */
    private static void findPath(BinaryTreeNode<Integer> root, int expectedSum,
                                 Stack<Integer> pathStack, int currentSum) {
        // 将当前遍历的节点的值加到currentSum中
        currentSum += root.value;
        // 将当前遍历的节点入栈
        pathStack.push(root.value);
        // 判断当前节点是不是叶结点
        boolean isLeaf = (root.leftChild == null && root.rightChild == null);
        // 如果是叶结点，并且该路径上节点值的和正好是我们给定的目标值，则加入结果列表
        if (currentSum == expectedSum && isLeaf) {
            System.out.println("A path has found!");
            resultList.add(pathStack.toString());
        }
        // 不是叶结点且左子节点不为空，遍历左子树
        if (root.leftChild != null) {
            findPath(root.leftChild, expectedSum, pathStack, currentSum);
        }
        // 不是叶结点且右子节点不为空，遍历右子树
        if (root.rightChild != null) {
            findPath(root.rightChild, expectedSum, pathStack, currentSum);
        }
        // 要将处理过的节点值出栈
        pathStack.pop();
    }
    /*------------------------------EndOfQuestion2------------------------------*/

    /*------------------------------Question3------------------------------*/

    /**
     * 通过前序遍历和中序遍历序列构建二叉树
     * @param preOrder
     * @param inOrder
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> BinaryTreeNode<T> constructTree(
            T[] preOrder, T[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
            throw new IllegalArgumentException("Invalid arguments!");
        }
        // 获取遍历数组的长度
        int length = preOrder.length;
        // 调用主构建函数
        return constructTreeCore(preOrder, 0, length - 1, inOrder, 0, length - 1);
    }

    /**
     * 通过前序遍历和中序遍历序列构建二叉树核心递归函数
     * @param preOrder 前序遍历序列
     * @param preStart 前序开始索引
     * @param preEnd 前序结束索引
     * @param inOrder 中序遍历序列
     * @param inStart 中序开始索引
     * @param inEnd 中序结束索引
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> BinaryTreeNode<T> constructTreeCore(
            T[] preOrder, int preStart, int preEnd,
            T[] inOrder, int inStart, int inEnd) {
        // 创建当前遍历的根节点
        BinaryTreeNode<T> root = new BinaryTreeNode<T>(preOrder[preStart]);
        root.leftChild = root.rightChild = null;

        // 递归终止基准条件，前序和中序都指向同一个节点两个节点值相同
        if (preStart == preEnd) {
            if (inStart == inEnd && preOrder[preStart].compareTo(inOrder[inStart]) == 0) {
                return root;
            } else {
                throw new IllegalArgumentException("Invalid Input");
            }
        }

        // 在中序遍历中查找当前根节点
        int rootInOrder = inStart;
        for (; rootInOrder <= inEnd && inOrder[rootInOrder].compareTo(root.value) != 0; ++rootInOrder);
        // 如果搜索到最后也没有找到，那么说明输入参数有问题
        if (rootInOrder == inEnd && inOrder[rootInOrder].compareTo(root.value) != 0)
            throw new IllegalArgumentException("Invalid Input");

        // 构建二叉树
        int leftLength = rootInOrder - inStart;
        int leftPreOrderEnd = preStart + leftLength;
        // 如果存在左子树
        if (leftLength > 0) {
            // 构建左子树
            root.leftChild = constructTreeCore(preOrder, preStart + 1, leftPreOrderEnd,
                    inOrder, inStart, rootInOrder - 1);
        }
        // 如果存在右子树
        if (leftLength < preEnd - preStart) {
            // 构建右子树
            root.rightChild = constructTreeCore(preOrder, leftPreOrderEnd + 1, preEnd,
                    inOrder, rootInOrder + 1, inEnd);
        }

        return root;
    }

    /*------------------------------EndOfQuestion3------------------------------*/

}
