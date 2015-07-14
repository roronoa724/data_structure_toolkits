package com.lanfea.dataStructure.Tree;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeUtils {

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

}
