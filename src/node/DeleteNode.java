package node;


import com.arithmetic_list.ListNode;

/**
 * 删除链表节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

   返回删除后的链表的头节点。

   注意：此题对比原题有改动

   示例 1:

   输入: head = [4,5,1,9], val = 5
   输出: [4,1,9]
   解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
   示例 2:

   输入: head = [4,5,1,9], val = 1
   输出: [4,5,9]
   解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

   来源：力扣（LeetCode）
   链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DeleteNode {


    /**
     * 方案一 指针法
     *
     * @param head 头结点
     * @param val 目标值
     * @return 结果
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        // 如果头结点刚好满足，就返回后面的节点
        if (cur.data == val){
            return head.next;
        }
        while (cur.next != null && cur.next.data != val){
            cur = cur.next;
        }
        // 删除节点
        cur.next = cur.next.next;
        return head;
    }

    /**
     * 递归方法
     * @param head 头节点
     * @param val 目标值
     * @return 结果
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null){
            return head;
        }
        if (head.data == val){
            return head.next;
        }
        head.next = deleteNode2(head.next,val);
        return head;
    }

    // 上述两种方法，时间复杂度： O(n)，空间复杂度：O(1)

}
