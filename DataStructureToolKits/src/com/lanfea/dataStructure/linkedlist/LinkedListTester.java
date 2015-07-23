package com.lanfea.dataStructure.linkedlist;

import com.lanfea.util.generator.RandomGenerator;

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
        Integer[] array1 = new Integer[]{1,2,3};
        Integer[] array2 = new Integer[]{1,2,5,6,7,8,9,10};
        LinkedListNode<Integer> head1 = LinkedListCreater.getInstance().constructLinkedList(array1);
        LinkedListNode<Integer> head2 = LinkedListCreater.getInstance().constructLinkedList(array2);
//        LinkedListTraverser.getInstance().normalForwardTraverse(head,tester);
//        System.out.println();
//        LinkedListUtils.printLinkedListReversingly(head);
//        LinkedListNode<Integer> node = LinkedListUtils.reverseList(head);
//        LinkedListTraverser.getInstance().normalForwardTraverse(node, tester);
        LinkedListNode<Integer> mergeHead = LinkedListUtils.mergeSortedLinkedList(head1, head2);
//        System.out.println(mergeHead.data);
        LinkedListTraverser.getInstance().normalForwardTraverse(mergeHead,tester);
    }
}
