package com.lanfea.dataStructure.tree;

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


}
