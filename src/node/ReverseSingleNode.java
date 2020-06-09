package node;

/**
 *
 * 翻转单链表
 *
 * 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list

 */
public class ReverseSingleNode {

    public static void main(String[] args){
        SingleNode singleOne1 = new SingleNode(7);
        SingleNode singleOne2 = new SingleNode(0);
        SingleNode singleOne3 = new SingleNode(9);
        SingleNode singleOne4 = new SingleNode(1);
        SingleNode singleOne5 = new SingleNode(5);
        singleOne1.next = singleOne2;
        singleOne2.next = singleOne3;
        singleOne3.next = singleOne4;
        singleOne4.next = singleOne5;

        SingleNode node = reverseSingleNode2(singleOne1);
        // 打印单链表
        printNode(node);
    }

    /**
     * 单链表翻转 (递归实现)
     * @param head 输入链表
     * @return 翻转的新链表
     */
    public static SingleNode reverseSingleNode(SingleNode head){
        // 方法一：
        SingleNode listNode = head;
        if (head !=null && head.next !=null) {
            listNode = reverseSingleNode(head.next);
            head.next.next = head;
            head.next = null;
        }
        return listNode;
    }

    /**
     * 单链表翻转 (非递归实现)
     * 总结下这个算法的思路：
     * next    : 临时存放下一个节点，方便后续current 指针移动
     * current : 当前位置节点，相当于head 节点
     * pre     : 前一个节点，将最终翻转的链表存入
     *
     * 7,0,9,1,5,null
     *
     * 一轮：
     * pre : 7,null
     * current : 0,9,1,5,null
     *
     * 二轮：
     * next = current.next;  // 9,1,5,null
     * current.next = pre;  // 之前pre 是7 null ，因此，这段执行后 current.next = 7,null .即：current = 0，7，null
     * pre = current; // 0，7，null
     * current = next; // 9,1,5,null
     *
     * @param head 输入链表
     * @return 翻转的新链表
     */
    public static SingleNode reverseSingleNode2(SingleNode head){
        SingleNode current = head;
        SingleNode pre = null;
        SingleNode next;
        while (current != null) {
            // 取出 next
            next = current.next;
            // 将上一个赋值给 next
            current.next = pre;
            // 更改 上一个到当前位置
            pre = current;
            // 当前位置往下移动
            current = next;
        }
        return pre;
    }

    private static void printNode(SingleNode node) {
        while (node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }

}


