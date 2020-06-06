package com.arithmetic_tree;

/**
 * 二叉树算法
 */
public class ArithmeticTreeMain {
    public static void main(String[] args) {
        int[] data = {8, 5, 9, 2, 3, 6, 4, 1, 7};
        // 创建一个二叉树
        BsTree tree = new BsTree(new TreeNode(data[0]));
        tree.createTree(data);
        System.out.println("树的大小：" + tree.getSize(tree.getRoot()));
        //  前序遍历（非递归方法）
        System.out.println("前序遍历:");
        tree.preOrder(tree.getRoot());
        //  中序遍历（非递归方法）
        System.out.println("中序遍历:");
        tree.midOrder(tree.getRoot());
        //  后序遍历（非递归方法）
        System.out.println("后序遍历");
        tree.lastOrder(tree.getRoot());
        // 是否是平衡二叉树
        System.out.println("二叉树状态:"+tree.isBalanced(tree.getRoot()));
    }


}
