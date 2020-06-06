package com.arithmetic_list;

/**
 * 链表测试主函数
 */
public class ArithmeticListMain {

    public static void main(String[] args) {
        int[] data1 = { 1, 2, 3,4, 5, 6, 7 };
        ListNode head = createNode(data1);
        System.out.print("--------"+"\n");
        // 删除倒数第三个节点
        ListNode listNode1 = ArithmeticListMethod.removeLastNode(head,1);
        while (listNode1 != null) {
            System.out.print(listNode1.data);
            listNode1 = listNode1.next;
        }
        System.out.print("\n");
        System.out.print("--------"+"\n");
        // 删除指定数值的节点
        ListNode listNode2 = ArithmeticListMethod.removeValue(head,1);
        while (listNode2 != null) {
            System.out.print(listNode2.data);
            listNode2 = listNode2.next;
        }
        System.out.print("\n");
        System.out.print("--------"+"\n");
    }

    /**
     * 创建一个链表
     * @param data
     * @return
     */
    public static ListNode createNode(int data[]){
        // 创建一个头节点
        ListNode head = new ListNode(data[0]);
        ListNode temp = head;
        for (int i = 1; i < data.length; i++) {
            ListNode headNext = new ListNode(data[i]);
            temp.next = headNext;
            temp = temp.next;
        }
        return head;
    }
}
