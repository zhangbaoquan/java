package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。

 示例：

 输入：

        4
     /    \
    2     7
  /  \   / \
 1   3  6   9
 输出：

        4
     /     \
    7      2
  /  \   /  \
 9   6  3   1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseTree {

    public static void main(String[] args) {

    }

    /**
     * 递归版本，其实就是左右交换
     * 由于树中每一个节点都需要被访问，因此时间复杂度就是O(n),其中n 是节点个数
     * 本方法使用了递归，在最坏情况下栈内存需要存放O(h)个方法调用，其中h是树的高度，由于h属于O(n)，可得空间复杂度是O(n)
     */
    private static TreeNode reverseTree1(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.leftChild;
        root.leftChild = reverseTree1(root.rightChild);
        root.rightChild = reverseTree1(temp);
        return root;
    }

    /**
     * 非递归版本，即使用迭代法
     * 创建一个队列来存储所有的左孩子和右孩子还没有被交换过的节点，开始的时候仅根节点在队列中，只要队列不为空，
     * 就一直从队列中取出节点，然后交换这个节点的左右孩子节点，接着再把孩子节点放入队列中，对于其中的空节点不用加到队列中，
     * 因为最后队列一定为空，这个时候所有的孩子节点已经被交换过了，所以最后再返回根节点即可。
     */

    private static TreeNode reverseTree2(TreeNode root){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode tmp = current.leftChild;
            current.leftChild = current.rightChild;
            current.rightChild = tmp;
            if (current.leftChild != null) queue.add(current.leftChild);
            if (current.rightChild != null) queue.add(current.rightChild);
        }

        return root;
    }


    public static void println(Object object) {
        System.out.print(object);
    }
}
