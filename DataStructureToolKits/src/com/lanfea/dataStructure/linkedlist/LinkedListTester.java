package com.lanfea.dataStructure.linkedlist;

/**
 * Created by lanfea on 2015/7/23.
 */
public class LinkedListTester implements LinkedListTraverser.Callback{

    @Override
    public void visit(LinkedListNode node) {
        System.out.print(node.data + ", ");
    }

    public static void main(String[] args) {
        LinkedListTester tester = new LinkedListTester();
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        LinkedListNode<Integer> head = LinkedListCreater.getInstance().constructLinkedList(array);
//        LinkedListTraverser.getInstance().normalForwardTraverse(head,tester);
        LinkedListUtils.printLinkedListReversingly(head);
    }
}
