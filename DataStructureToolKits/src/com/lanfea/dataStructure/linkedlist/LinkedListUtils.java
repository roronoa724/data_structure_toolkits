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
        // 先行节点
        LinkedListNode<T> aheadNode = head;
        // 后行节点
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

    /*------------------------------Question3------------------------------*/

    /**
     * 原地反转链表
     * @param head
     * @param <T>
     * @return
     */
    public static <T> LinkedListNode<T> reverseList(LinkedListNode<T> head) {
        if (head == null)
            return null;
        // 反转后链表的头节点
        LinkedListNode<T> reversedHead = null;
        // 当前遍历到的节点
        LinkedListNode<T> currentNode = head;
        // 当前遍历节点的前一个节点，head的前一个节点可以看作是null
        LinkedListNode<T> prevNode = null;
        while (currentNode != null) {
            LinkedListNode<T> nextNode = currentNode.next;
            if (nextNode == null)
                reversedHead = currentNode;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return reversedHead;
    }
    /*------------------------------EndOfQuestion3------------------------------*/

    /*------------------------------Question4------------------------------*/

    public static <T extends Comparable<? super T>> LinkedListNode<T> mergeSortedLinkedList(LinkedListNode<T> head1,
                                                              LinkedListNode<T> head2) {
        // 初始条件判断
        if (head1 == null && head2 == null)
            return null;
        if (head1 == null && head2 != null)
            return head2;
        if (head2 == null && head1 != null)
            return head1;

        // 合并之后的链表头节点
        LinkedListNode<T> mergeHead = new LinkedListNode<T>();
        LinkedListNode<T> runner = mergeHead;

        // 被合并的两个链表都不为空
        while (head1 != null && head2 != null) {
            // head1指向的值小于head2指向的值
            if (head1.data.compareTo(head2.data) < 0) {
                // 第一次比较时
                if (runner == null)
                    runner = head1;
                else {
                    runner.next = head1;
                    runner = runner.next;
                }
                head1 = head1.next;
            }
            // head1指向的值大于等于head2指向的值
            else {
                // 第一次比较时
                if (runner == null)
                    runner = head2;
                else {
                    runner.next = head2;
                    runner = runner.next;
                }
                head2 = head2.next;
            }
        }
        // 后处理，将不为空的剩余有序链表链接进来
        if (head1 != null) {
            runner.next = head1;
        }
        if (head2 != null) {
            runner.next = head2;
        }
        return mergeHead.next;
    }
    /*------------------------------EndOfQuestion4------------------------------*/
}
