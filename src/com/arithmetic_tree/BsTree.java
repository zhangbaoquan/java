package com.arithmetic_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 链式存储二叉树
 * 二叉树的算法基本都用到了"递归"、"分治"的思想。
 */
public class BsTree {
    private TreeNode root = null;

    /**
     * 获取根节点
     * @return
     */
    public TreeNode getRoot(){
        return root;
    }

    public BsTree(TreeNode node){
        this.root = node;
    }

    /**
     * 创建一个二叉树
     * @param data
     */
    public void createTree(int data[]){
        for (int i = 1; i < data.length; i++) {
            addNode(root,data[i]);
        }
    }

    /**
     * 将节点添加到二叉树
     * @param data
     * @return
     */
    private TreeNode addNode(TreeNode root,int data){
        if (root == null){
            root  = new TreeNode(data);
        }
        // 大数放右子树，小数放左子树
        if (data > root.value){
            root.rightChild = addNode(root.rightChild,data);
            return root;
        }else if (data < root.value){
            root.leftChild = addNode(root.leftChild,data);
            return root;
        }
        return root;
    }

    /**
     * 获取当前节点的父节点
     * @param root
     * @param element
     * @return
     */
    public TreeNode getParent(TreeNode root,TreeNode element){
        if (root == null){
            return null;
        }
        if (root.leftChild == element || root.rightChild == element){
            return root;
        }
        TreeNode node;
        // 分别递归左右子树来搜索当前节点的父节点
        if ((node = getParent(root.leftChild,element)) != null ){
            return node;
        }else {
            return getParent(root.rightChild,element);
        }
    }

    /**
     * 获取该节点的左孩子节点
     * @param element
     * @return
     */
    public TreeNode getChildLeftNode(TreeNode element){
        if (element != null){
            return element.leftChild;
        }else {
            return null;
        }
    }

    /**
     * 获取该节点的右孩子
     * @param element
     * @return
     */
    public TreeNode getChildRightNode(TreeNode element){
        if (element == null){
            return null;
        }else {
            return element.rightChild;
        }
    }

    /**
     * 获取二叉树的大小(二叉树中节点的个数)
     * @param root
     * @return
     */
    public int getSize(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return 1 + getSize(root.leftChild) + getSize(root.rightChild);
        }
    }

    /**
     * 获取二叉树的高度
     * @param root
     * @return
     */
    public int getHeigh(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = getHeigh(root.leftChild);
        int rightHeight = getHeigh(root.rightChild);
        return Math.max(leftHeight,rightHeight)+1;
    }

    /**
     * 获取二叉树的最小高度
     * @param root
     * @return
     */
    public int getMinHeigh(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.leftChild == null || root.rightChild == null){
            return 1;
        }else {
            return Math.min(getMinHeigh(root.leftChild),getMinHeigh(root.rightChild))+1;
        }
    }

    /**
     * 判断当前树是否是平衡二叉树.
     * 性质：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * @param root
     * @return -1：表示不是,1：是
     */
    public int isBalanced(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = isBalanced(root.leftChild);
        int right = isBalanced(root.rightChild);
        if (left == -1 || right == -1 || Math.abs(left-right) >1){
            return -1;
        }else {
            return 1;
        }
    }

    /**
     * 判断当前树是否是完全二叉树
     * @return
     */
    public int isCompleteTreeNode(TreeNode root){
        if (root == null){
            return 0;
        }
        return 0;
    }

    /**
     * 判断当前树是否是满二叉树
     * @return
     */
    public int isFullTreeNode(TreeNode root){
        if (root == null){
            return 0;
        }
        return 0;
    }

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public TreeNode reverseTree(TreeNode root){
        if (root == null){
            return null;
        }
        // 分别翻转左子树、右子树
        TreeNode left = reverseTree(root.leftChild);
        TreeNode right = reverseTree(root.rightChild);
        // 将翻转好的左右子树赋值给根节点，实现翻转
        root.leftChild = right;
        root.rightChild = left;
        return root;
    }

    /**
     * 将二叉树铺平：把一个二叉树变成一个类似于链表的结构，所有的子节点都移到右节点去
     * @param root
     * @return
     */
    public TreeNode flatten(TreeNode root){
        if (root == null){
            return null;
        }
        // 1、利用分治、递归将左右子树铺平
        TreeNode left = flatten(root.leftChild);
        TreeNode right = flatten(root.rightChild);
        // 2、将树的左右指针指向空
        root.leftChild = null;
        root.rightChild = null;
        // 3、如果左子树为空，则将右子树生成的链表衔接到根节点的右指针上
        if (left == null){
            root.rightChild = right;
            return root;
        }
        root.leftChild = left;
        TreeNode lastLeft = left;
        // 4、如果左子树不为空，使用循环找到左子树的最后一个节点，并使它的右指针指向右子树生成的链表的头节点
        while (lastLeft != null && lastLeft.rightChild != null){
            lastLeft = lastLeft.rightChild;
        }
        lastLeft.rightChild = right;
        return root;
    }

    // 非常重要的题目！！！
//    /**
//     * 返回一个在ViewGroup下面的一个View，id为方法的第二个参数
//     * 解析：ViewGroup也是一个树形结构
//     * @param vg
//     * @param id
//     * @return
//     */
//    public static View find(ViewGroup vg ,int id){
//        if (vg == null){
//            return null;
//        }
//        int count = vg.getChildCount();
//        // 遍历ViewGroup中的所有子元素
//        for (int i = 0; i < count; i++) {
//            View view = vg.getChildAt(i);
//            // 如果当前View是要查找的，则直接返回
//            if (view.getId() == id){
//                return view;
//            }
//            // 如果当前View是ViewGroup，
//            if (view instanceof ViewGroup){
//                // 递归遍历，继续找。找到就返回，否则继续遍历
//                View temp = find((ViewGroup)view,id);
//                if (temp != null){
//                    return temp;
//                }
//            }
//        }
//        // 遍历完后没有找到，则返回结果为null
//        return null;
//    }

    /**
     * 二叉树的层序处理(广度优先)
     * 思想：利用队列先进先出的性质，我们可以一层层的打印二叉树的节点们
     *      每次遍历当前节点的时候，把该节点从队列拿出来，并且把它的子节点全部加入到队列中
     * @param root
     */
    public void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println("data: "+node.value);
            if (node.leftChild != null){
                queue.add(node.leftChild);
            }
            if (node.rightChild != null){
                queue.add(node.rightChild);
            }
        }
    }

    // 二叉树的递归（深度优先）处理，前序、中序、后序遍历
    /**
     * 前序遍历（非递归）
     * @param root
     */
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        // 首先将根节点压入栈中
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        // 注意，一定要先压入右孩子，然后在左入右孩子。这样就可以利用栈在最后输出时先输出左孩子，然后是右孩子
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println("data: "+node.value);
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }
            if (node.leftChild != null){
                stack.push(node.leftChild);
            }
        }
    }

    /**
     * 前序遍历（递归）
     * @param root
     */
    public void preOrder2(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println("data:"+ root.value);
        preOrder2(root.leftChild);
        preOrder2(root.rightChild);
    }

    /**
     * 中序遍历（非递归）【先将左节点压入栈中，弹出左节点。再压右节点再弹出】
     * @param root
     */
    public void midOrder(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()|| node != null ){
            if (node != null){
                stack.push(node);
                node = node.leftChild;
            }else {
                node = stack.pop();
                System.out.println("data: "+node.value);
                node = node.rightChild;
            }
        }
    }

    /**
     * 后序遍历（非递归）【使用两个栈，第一个栈用来添加节点的左右孩子，第二个栈用来反转第一个栈的内容，然后输出】
     * @param root
     */
    public void lastOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> inStack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();
        inStack.push(root);
        // 首先将栈1的栈顶元素放到栈2中，然后在将栈1的左右节点元素依次压入到栈中。直到栈1的全部元素都压入到栈2中
        while (!inStack.isEmpty()){
            TreeNode node = inStack.pop();
            outStack.push(node);
            if (node.leftChild != null){
                inStack.push(node.leftChild);
            }
            if (node.rightChild != null){
                inStack.push(node.rightChild);
            }
        }
        // 遍历输出栈2里的元素
        while (!outStack.isEmpty()){
            System.out.println("data:"+outStack.pop().value);
        }
    }

}
