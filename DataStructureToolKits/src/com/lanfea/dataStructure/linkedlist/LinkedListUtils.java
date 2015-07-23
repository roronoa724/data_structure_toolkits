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
    /*------------------------------EndOfQuestion2------------------------------*/
}
