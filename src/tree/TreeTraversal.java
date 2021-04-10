package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历，分前、中、后序遍历
 * 这三种遍历，又分两类。分别是递归遍历和非递归遍历
 */
public class TreeTraversal {

    /**  使用递归实现前、中、后序遍历   **/

    /**
     * 前序递归遍历
     *
     * @param root 根节点
     */
    public void PreRecursionTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        PreRecursionTraversal(root.leftChild);
        PreRecursionTraversal(root.rightChild);
    }

    /**
     * 中序遍历遍历
     *
     * @param root 根节点
     */
    public void MidleRecursionTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        MidleRecursionTraversal(root.leftChild);
        System.out.print(root.data);
        MidleRecursionTraversal(root.rightChild);
    }

    /**
     * 后续递归遍历
     *
     * @param root 根节点
     */
    public void PostRecursionTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        PostRecursionTraversal(root.rightChild);
        PostRecursionTraversal(root.leftChild);
        System.out.print(root.data);
    }

    /**  使用非递归实现前、中、后序遍历，这里主要是利用栈  **/

    /**
     * 前序迭代遍历
     *
     * @param root 根节点
     */
    public void PreIterationsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data);
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
        }
    }

    /**
     * 中序迭代遍历，先打印左节点，再打印根节点，最后打印右节点
     *
     * @param root 根节点
     */
    public void MidIterationsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.leftChild;
            } else {
                cur = stack.pop();
                System.out.print(cur.data);
                cur = cur.rightChild;
            }
        }

    }

    /**
     * 后序迭代遍历，先打印左节点，再打印根节点，最后打印右节点
     *
     * @param root 根节点
     */
    public void PostIterationsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 用于添加node和它的左右孩子
        Stack<TreeNode> stack1 = new Stack<>();
        // 用于翻转第一个stack 的输出
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            // 将栈顶元素存入第二个栈中
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.leftChild != null) {
                stack1.push(node.leftChild);
            }
            if (node.rightChild != null){
                stack1.push(node.rightChild);
            }
        }
        // 输出第二个栈
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data);
        }

    }

    /**
     * 二叉树层序遍历输出
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arrayList.add(node.data);
            if (node.leftChild != null){
                queue.add(node.leftChild);
            }
            if (node.rightChild != null){
                queue.add(node.rightChild);
            }
        }
        int[] r = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            r[i] = arrayList.get(i);
        }
        return r;
    }
}
