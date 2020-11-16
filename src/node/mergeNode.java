package node;

import com.arithmetic_list.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 例如1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 例如2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 例如3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class mergeNode {
    public static void main(String[] args) {

    }

    /**
     * 用一个变量 ans 来维护以及合并的链表，第i次循环把第i 个链表和 ans 合并，答案保存到 ans 中。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param lists 目标链表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result, list);
        }
        return result;
    }

    /**
     * 合并两个链表
     *
     * @param a 链表1
     * @param b 链表2
     * @return 合并后有序的链表
     */
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            // 首次循环合并，a 链表是空，后面b 赋值给a 就相当于数组的前后两个链表合并
            return a != null ? a : b;
        }
        // head 节点相当于一个哨兵，方便书写记录
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode aPtr = a;
        ListNode bPtr = b;
        // 两个链表不为空时，取最小的合并入
        while (aPtr != null && bPtr != null) {
            if (aPtr.data < bPtr.data) {
                cur.next = aPtr;
                aPtr = aPtr.next;
            } else {
                cur.next = bPtr;
                bPtr = bPtr.next;
            }
            cur = cur.next;
        }

        // 注意：如果 aPtr 为空，则把整个 bPtr 以及后面的元素全部合并；bPtr 为空时同理。
        cur.next = (aPtr != null ? aPtr : bPtr);

        return head.next;
    }
}
