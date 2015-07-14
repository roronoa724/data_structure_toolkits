package com.lanfea.dataStructure.Tree;

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
        BinaryTreeTraverser.getInstance().nonRecursivePreOrderTraverse(root,tester);
        System.out.println();
        BinaryTreeTraverser.getInstance().nonRecursiveInOrderTraverse(root, tester);
        System.out.println();
        BinaryTreeTraverser.getInstance().nonRecursivePostOrderTraverse(root, tester);
        System.out.println();
    }
}
