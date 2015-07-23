package com.lanfea.dataStructure.linkedlist;


/**
 * Created by lanfea on 2015/7/23.
 */
public class LinkedListTraverser {

    public interface Callback<T> {
        void visit(LinkedListNode<T> node);
    }

    private LinkedListTraverser() {

    }
    public static LinkedListTraverser getInstance() {
        return Nested.instance;
    }

    static class Nested {
        private static LinkedListTraverser instance = new LinkedListTraverser();
    }

    /**
     * 常规的前向遍历
     * @param head
     * @param callback
     * @param <T>
     */
    public <T> void normalForwardTraverse(LinkedListNode<T> head, Callback callback) {
        if (head == null)
            return;
        while(head!= null) {
            callback.visit(head);
            head = head.next;
        }
    }
}
