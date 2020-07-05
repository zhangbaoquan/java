package node;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]

 限制：

 0 <= 链表长度 <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintReverseSingleNode {

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
//        printReverseSingleNode(singleOne1);
        int[] num = reversePrint(singleOne1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
    }

    private static void printReverseSingleNode(SingleNode head){
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }

    /**
     * 按照LeetCode 要求，返回一个数组
     * @param head 链表
     * @return 返回数组
     */
    public static int[] reversePrint(SingleNode head) {
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        while (head != null){
            size++;
            stack.push(head.data);
            head = head.next;
        }
        int[] num = new int[size];
        int index = 0;
        while (!stack.empty()){
            num[index++] = stack.pop();
        }
        return num;
    }
}
