package tree;

/**
 * @author coffer
 * @Description : 二叉树的深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 解析：
 * 树的遍历算法分两类：DFS、BFS。
 * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
 * 常见的 BFS ： 层序遍历（即按层遍历）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/12 4:02 下午
 */
public class MaxDepth {


    /**
     * 方案一：即后序遍历（DFS），这里是使用递归算法
     *
     * 时间复杂度：O(N) ,即N为节点数量
     * 空间复杂度：O(N) ，最差情况下（当树退化为链表时），深度可以达到N
     * @param root 根节点
     * @return 层数
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return 1 + Math.max(maxDepth(root.leftChild),maxDepth(root.rightChild));
        }
    }

}

