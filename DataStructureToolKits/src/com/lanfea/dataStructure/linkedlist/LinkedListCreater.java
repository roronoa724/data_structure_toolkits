package com.lanfea.dataStructure.linkedlist;

/**
 * Created by lanfea on 2015/7/23.
 */
public class LinkedListCreater {

    private LinkedListCreater() {

    }

    public static LinkedListCreater getInstance() {
        return Nested.instance;
    }

    static class Nested {
        private static LinkedListCreater instance = new LinkedListCreater();
    }

    /**
     * 根据数组构造单向链表
     * @param array
     * @param <T>
     * @return
     */
    public <T> LinkedListNode<T> constructLinkedList(T[] array) {
        if (array == null)
            return null;
        LinkedListNode<T> head = null;
        // 如果数组为空，返回一个空的头节点
        if (array.length == 0) {
            head = new LinkedListNode<T>();
        }
        // 如果数组的长度大于1，那么顺次遍历数组并建立链表
        else {
            head = new LinkedListNode<T>(array[0]);
            LinkedListNode<T> runner = head;
            for (int i = 1; i < array.length; ++i) {
                LinkedListNode<T> node = new LinkedListNode<T>(array[i]);
                runner.next = node;
                runner = runner.next;
            }
        }
        return head;
    }


}
