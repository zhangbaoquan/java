package com.arithmetic_list;

import java.util.Stack;

/**
 * 描述：链表算法
 */
public class ArithmeticListMethod {

    /**
     * 在链表中，删除指定数值的节点，利用栈结构
     *
     * @param head
     * @param num
     * @return
     */
    public static ListNode removeValue(ListNode head, int num) {
        Stack<ListNode> stack = new Stack();
        // 将链表中所有不等于要删除的节点放入栈中
        while (head != null) {
            if (head.data != num) {
                stack.push(head);
            }
            head = head.next;
        }
        // 出栈，将头节点指向栈顶（相当于元原链表最后一个节点），然后依次弹出，直到指向原链表首节点
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 删除链表中的一个节点，删除成功返回true，失败返回false
     * 注意：要考虑三种情况，分别是要删除的节点是"尾节点"、"头节点"、"普通节点"
     *
     * @param head
     * @param listNode
     * @return
     */
    public static boolean deleteNode(ListNode head, ListNode listNode) {
        if (head != null && listNode != null) {
            // 如果当前要删除的节点是【尾节点】，则按顺序查找到尾节点的前一个节点，并设置成null.
            if (listNode.next == null) {
                while (head.next != listNode) {
                    head = head.next;
                }
                head.next = null;
            }
            // 如果当前要删除的节点是【头节点】
            else if (head.next == null) {
                head = null;
            }
            // 要删除的节点是普通节点
            else {
                ListNode q = listNode.next;
                listNode.next = q.next;
                listNode.data = q.data;
            }
            return true;
        } else {
            // 链表为空，无法删除，则链表删除失败
            return false;
        }
    }

    /**
     * 删除单链表的倒数第K个节点。解析如下：
     * 1.首先判断K值和链表是否为空，如果k<=0,或链表为空，直接返回head；
     * 2.遍历一遍链表，每走一步，让k值减1.
     * 3.遍历完后，如果k大于零，说明k大于链表长度，直接返回head；如果k等于0，要删除的节点就是头结点，直接返回head.next;如果k小于0时候第4步。
     * 4.定义q=head，从新遍历节点，每走一步k加1，直到k=0时候，退出循环，此时q的下一个节点就是要删除的节点。
     * （4.解析：在这部分，为什么这样做，可能不是很容易理解，给大家举个例子，假如现在有一链表有8个节点，k=3.
     * 那么，前三步后，k=-5。大家想一想，k等于三是要删除倒数第3个节点，我们只要从头走5步就可以到达删除节点的前一个节点了，
     * 为啥是5，因为8 = 3+5。说道这里不知道你明白没有。）
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeLastNode(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            p = p.next;
            k--;
        }
        if (k == 0) {
            return head.next;
        }
        if (k < 0) {
            ListNode q = head;
            while (++k != 0){
                q = q.next;
            }
            q.next = q.next.next;
        }
        return head;
    }


}
