package com.lanfea.dataStructure.Tree;

/**
 * Created by lanfea on 2015/7/14.
 */
public class BinaryTreeTester implements BinaryTreeTraverser.Callback{

    @Override
    public void visit(BinaryTreeNode node) {
        System.out.print(node.value + " ");
    }

    static final Integer[] preOrder = {1,2,4,7,3,5,6,8};
    static final Integer[] inOrder = {4,7,2,1,5,3,8,6};
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.constructTree(preOrder,inOrder);
        BinaryTreeTraverser.getInstance().inOrderTraverse(root,new BinaryTreeTester());
    }
}
