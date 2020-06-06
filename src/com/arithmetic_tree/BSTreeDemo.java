package com.arithmetic_tree;

import java.util.Arrays;
import java.util.Stack;

public class BSTreeDemo {
    private TreeNodeDemo root = null;

    public TreeNodeDemo getRoot() {
        return root;
    }

    public BSTreeDemo(TreeNodeDemo root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // 树的高度
    public int height() {
        return TreeNodeDemo.height(root);
    }

    // 节点个数
    public int size() {
        return TreeNodeDemo.size(root);
    }

    // 返回树中某节点的父节点
    public TreeNodeDemo parent(TreeNodeDemo element) {
        return (root == null || root == element) ? null : TreeNodeDemo.getParent(root, element);
    }

    // 二叉搜索树
    public void add(int data) {
        add(root, data);
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    public int minValue() {
        return findMin(root).data;
    }

    public int maxValue() {
        return findMax(root).data;
    }

    private TreeNodeDemo findMin(TreeNodeDemo subTree) {
        if (null == subTree) {
            return null;
        } else if (null == subTree.leftChild) {
            return subTree;
        }
        return findMin(subTree.leftChild);
    }

    private TreeNodeDemo findMax(TreeNodeDemo subTree) {
        if (null != subTree) {
            while (null != subTree.rightChild) {
                subTree = subTree.rightChild;
            }
        }
        return subTree;
    }

    // 添加节点进搜索树
    private TreeNodeDemo add(TreeNodeDemo subTree, int data) {
        if (null == subTree) {
            return new TreeNodeDemo(data);
        } else if (data > subTree.data) {
            subTree.rightChild = add(subTree.rightChild, data);
            return subTree;
        } else if (data < subTree.data) {
            subTree.leftChild = add(subTree.leftChild, data);
            return subTree;
        } // 这里限定搜索树中元素不重复
        return subTree;
    }

    private boolean contains(TreeNodeDemo subTree, int data) {
        if (null == subTree) {
            return false;
        } else if (data > subTree.data) {
            return contains(subTree.rightChild, data);
        } else if (data < subTree.data) {
            return contains(subTree.leftChild, data);
        } else {
            return true;
        }
    }

    private TreeNodeDemo remove(TreeNodeDemo subTree, int data) {
        if (null == subTree) {
            return null;
        } else if (data > subTree.data) {
            return remove(subTree.rightChild, data);
        } else if (data < subTree.data) {
            return remove(subTree.leftChild, data);
        } else if (null == subTree.leftChild || null == subTree.rightChild) {  //节点匹配, 只有一个孩子或没有孩子
            return (subTree.leftChild != null) ? subTree.leftChild : subTree.rightChild;
        } else {      //节点匹配, 有两个孩子
            subTree.data = findMin(subTree.rightChild).data;
            subTree.rightChild = remove(subTree.rightChild, subTree.data);
            return subTree;
        }
    }

    // 定义树的节点
    private static class TreeNodeDemo {
        private int data;
        private TreeNodeDemo leftChild = null;
        private TreeNodeDemo rightChild = null;

        public TreeNodeDemo(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public static TreeNodeDemo getParent(TreeNodeDemo subTree, TreeNodeDemo element) {
            if (subTree == null)
                return null;
            if (subTree.leftChild == element || subTree.rightChild == element)
                return subTree;
            TreeNodeDemo p = null;
            // 递归左右子树
            if ((p = getParent(subTree.leftChild, element)) != null)
                return p;
            else
                return getParent(subTree.rightChild, element);
        }

        public static TreeNodeDemo getLeftChildNode(TreeNodeDemo element) {
            return (element != null) ? element.leftChild : null;
        }

        public static TreeNodeDemo getRightChildNode(TreeNodeDemo element) {
            return (element != null) ? element.rightChild : null;
        }

        public static int height(TreeNodeDemo subTree) {
            if (subTree == null)
                return 0;// 递归结束：空树高度为0
            else {
                int i = height(subTree.leftChild);
                int j = height(subTree.rightChild);
                return (i < j) ? (j + 1) : (i + 1);
            }
        }

        public static int size(TreeNodeDemo subTree) {
            if (subTree == null) {
                return 0;
            } else {
                return 1 + size(subTree.leftChild) + size(subTree.rightChild);
            }
        }

        // 在释放某个结点前, 该结点的左右子树应该已经释放, 所以应该采用后续遍历
        public static void destroySubTree(TreeNodeDemo subTree) {
            // 删除根为subTree的子树
            if (subTree != null) {
                destroySubTree(subTree.leftChild);
                destroySubTree(subTree.rightChild);
                // 删除根结点
                subTree = null;
            }
        }


        public static void visted(TreeNodeDemo subTree) {
            System.out.println("data: " + subTree.data);
        }

        // 前序遍历
        public static void preOrder(TreeNodeDemo subTree) {
            if (subTree != null) {
                visted(subTree);
                preOrder(subTree.leftChild);
                preOrder(subTree.rightChild);
            }
        }

        // 中序遍历
        public static void inOrder(TreeNodeDemo subTree) {
            if (subTree != null) {
                inOrder(subTree.leftChild);
                visted(subTree);
                inOrder(subTree.rightChild);
            }
        }

        // 后续遍历
        public static void postOrder(TreeNodeDemo subTree) {
            if (subTree != null) {
                postOrder(subTree.leftChild);
                postOrder(subTree.rightChild);
                visted(subTree);
            }
        }

        // 前序遍历的非递归实现
        public static void nonRecPreOrder(TreeNodeDemo subTree) {
            Stack<TreeNodeDemo> stack = new Stack<TreeNodeDemo>();
            TreeNodeDemo node = subTree;
            while (node != null || stack.size() > 0) {
                if (node != null) {
                    visted(node);
                    stack.push(node);
                    node = node.leftChild;
                } else {
                    node = stack.pop();
                    node = node.rightChild;
                }
            }
        }

        // 中序遍历的非递归实现
        public static void nonRecInOrder(TreeNodeDemo subTree) {
            Stack<TreeNodeDemo> stack = new Stack<TreeNodeDemo>();
            TreeNodeDemo node = subTree;
            while (node != null || stack.size() > 0) {
                // 存在左子树
                if (node != null) {
                    stack.push(node);
                    node = node.leftChild;
                } else {
                    node = stack.pop();
                    visted(node);
                    node = node.rightChild;
                }
            }
        }

        // 后序遍历的非递归实现
        public static void nonRecPostOrder(TreeNodeDemo subTree) {
            if (null == subTree) { //为确保下面循环至少执行一次
                return;
            }
            Stack<TreeNodeDemo> stack = new Stack<TreeNodeDemo>();
            TreeNodeDemo node = subTree;
            TreeNodeDemo lastVisited = subTree;
            while (true) {
                // 左路入栈
                while (node.leftChild != null) {
                    stack.push(node);    //第一次压栈, 为了访问左路后退出
                    node = node.leftChild;
                }
                // 连续处理从右路返回的节点
                while (node.rightChild == null || node.rightChild == lastVisited) {
                    // 访问并纪录本次访问节点
                    visted(node);
                    lastVisited = node;
                    if (stack.empty()) {
                        return;
                    }
                    node = stack.pop();
                }
                // 处理从左路返回的节点
                stack.push(node);  // 第二次压栈, 为了访问右路后退出
                node = node.rightChild;
            }
        }
    }

    // 测试
    public static void main(String[] args) {
        // 创建树
//        int[] values = new int[8];
//        for (int i = 0; i < 8; i++) {
//            int num = (int) (Math.random() * 15);
//            if (!checkDup(values, num))
//                values[i] = num;
//            else
//                i--;
//        }
        int[] values = {8, 5, 9, 2, 3, 6, 4, 1, 7};
        System.out.println("generate Nums:" + Arrays.toString(values));

        BSTreeDemo tree = new BSTreeDemo(new TreeNodeDemo(values[0]));
        for (int i = 1; i < values.length; i++) {
            tree.add(values[i]);
        }

        System.out.println("树高: " + TreeNodeDemo.height(tree.getRoot()));
        System.out.println("树大小: " + TreeNodeDemo.size(tree.getRoot()));
        System.out.println("前序遍历:");
        TreeNodeDemo.nonRecPreOrder(tree.getRoot());
        System.out.println("中序遍历:");
        TreeNodeDemo.nonRecInOrder(tree.getRoot());
        System.out.println("后序遍历:");
        TreeNodeDemo.nonRecPostOrder(tree.getRoot());
    }

    /**
     * 设置数组里的数据不重复
     *
     * @param arr
     * @param value
     * @return
     */
    private static boolean checkDup(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
}
