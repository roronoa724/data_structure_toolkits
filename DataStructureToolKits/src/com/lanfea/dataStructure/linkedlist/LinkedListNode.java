package com.lanfea.dataStructure.linkedlist;

/**
 * Created by lanfea on 2015/7/23.
 */
public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T data;
    public LinkedListNode() {
        next = null;
        data = null;
    }
    public LinkedListNode(T data) {
        next = null;
        this.data = data;
    }
    public LinkedListNode(LinkedListNode<T> next, T data) {
        this.next = next;
        this.data = data;
    }
}
