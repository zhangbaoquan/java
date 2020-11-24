package node;

import com.arithmetic_list.ListNode;

/**
 * 链表中倒数第K个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。


 示例：

 给定一个链表: 1->2->3->4->5, 和 k = 2.

 返回链表 4->5.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FindKNode {


    /**
     * 使用双指针法
     * latter 与尾节点距离 k−1，即 latter 指向倒数第 k 个节点
     * @param head 目标链表
     * @param k 倒数第K 个数
     * @return 结果
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = fast;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
