package com.lanfea.dataStructure.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeTester implements BinaryTreeTraverser.Callback{

    @Override
    public void visit(BinaryTreeNode node) {
        System.out.print(node.value + " ");
    }

    static final Integer[] array = {10,6,14,4,8,12,16,1,5};
    public static void main(String[] args) {
        BinaryTreeTester tester = new BinaryTreeTester();
        BinaryTreeNode<Integer> root = BinaryTreeCreater.getInstance().constructBinaryTree(array);
        CopyOnWriteArrayList<String> resultList = new CopyOnWriteArrayList<String>();
        resultList = (CopyOnWriteArrayList<String>) BinaryTreeUtils.findPath(root, 21);
        System.out.print(resultList);
    }
}
