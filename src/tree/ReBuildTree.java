package tree;

import java.util.HashMap;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

  

 例如，给出

 前序遍历 preorder =[3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

    3
 /    \
 9    20
    /    \
   15     7

 限制：

 0 <= 节点个数 <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReBuildTree {

    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    static HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历（主要是记录中序数组里的值的索引）
    static int[] mPreorder;//保留的先序遍历

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        mPreorder = preorder;
        for (int i = 0; i < mPreorder.length; i++) {
            // 这里的key 是中序数组的是值，value是值对应的索引，后面我们会用前序数组的值取找中序数组的索引
            map.put(inorder[i], i);
        }
        return recursive(0,0,mPreorder.length-1);
    }

    /**
     * @param pre_root_idx 根节点索引
     * @param in_left_idx  左节点索引
     * @param in_right_idx 右节点索引
     */
    public static TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        TreeNode root = new TreeNode(mPreorder[pre_root_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = map.get(mPreorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.leftChild = recursive(pre_root_idx + 1, in_left_idx, idx - 1);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        root.rightChild = recursive(pre_root_idx + (idx-1 - in_left_idx +1)  + 1, idx + 1, in_right_idx);
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

}
