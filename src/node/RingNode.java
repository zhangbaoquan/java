package node;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个链表，判断链表中是否有环。

 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

 如果链表中存在环，则返回 true 。 否则，返回 false 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-cycle
 *
 */

public class RingNode {

    public static void main(String[] args){

    }

    /**
     * 使用哈希表
     * Set 集合不会有重复的值。
     * 时间复杂度是 O（n），因为一旦检测到有环，则执行n次
     * 空间复杂度是 O（1），哈希表的空间，一旦检测到有环，就要插入到哈希表N次
     * @param head 目标链表
     * @return true 标识当前有环
     */
    public static boolean hasCycle1(SingleNode head) {
        Set<SingleNode> temp = new HashSet<>();
        while (head != null){
            if (!temp.add(head)){
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 使用龟兔赛跑的模式
     * 我们可以根据上述思路来解决本题。具体地，我们定义两个指针，一快一满。
     * 慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，
     * 而快指针在位置 head.next。这样一来，如果在移动的过程中，快指针反过来追上慢指针，
     * 就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。
     * 时间复杂度是 O（n），因为一旦检测到有环，则执行n次
     * 空间复杂度是 O（1），因为仅使用了两个指针
     *
     * @param head 目标链表
     * @return true 表示当前有环
     */
    public static boolean hasCycle2(SingleNode head) {
        if (head == null || head.next == null){
            return false;
        }
        SingleNode fast = head.next; // 快指针
        SingleNode slow = head; // 慢指针
        while (fast != slow){
            if (fast == null || fast.next == null){
                // 快指针如果没有遇到环，那么就直接遍历到了最后。
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
