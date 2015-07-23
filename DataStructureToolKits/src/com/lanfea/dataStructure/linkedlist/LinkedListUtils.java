package com.lanfea.dataStructure.linkedlist;

import java.util.Stack;

/**
 * Created by lanfea on 2015/7/23.
 */
public class LinkedListUtils {
    /*------------------------------Question1------------------------------*/
    /**
     * 从尾到头打印链表
     * @param head
     * @param <T>
     */
    public static <T> void printLinkedListReversingly(LinkedListNode<T> head) {
        if (head == null)
            return;
        // 辅助栈
        Stack<T> stack = new Stack<T>();
        LinkedListNode<T> runner = head;
        // 遍历链表并将节点的数值推入栈中
        while (runner != null) {
            stack.push(runner.data);
            runner = runner.next;
        }
        // 如果栈不为空，将栈中的数值弹出并打印
        while (!stack.isEmpty()) {
            T data = stack.pop();
            System.out.print(data + " ");
        }
    }
    /*------------------------------EndOfQuestion1------------------------------*/

    /*------------------------------Question2------------------------------*/

    /**
     * 查找单向链表中的倒数第K个节点
     * @param head
     * @param <T>
     * @return
     */
    public static <T> LinkedListNode<T> findKthToTail(LinkedListNode<T> head, int k) {
        // 倒数第0个或者负数个节点没有意义
        if (head == null || k <= 0)
            return null;
        //先行节点
        LinkedListNode<T> aheadNode = head;
        //后行节点
        LinkedListNode<T> behindNode = null;
        for (int i = 0; i < k - 1; ++i) {
            if (aheadNode.next != null)
                aheadNode = aheadNode.next;
            // 还没有遍历到第k-1个就越界了，说明k要比链表的长度还要大，显然是非法的
            else
                return null;
        }
        behindNode = head;
        while(aheadNode.next != null) {
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }
    /*------------------------------EndOfQuestion2------------------------------*/
}
