package node;

/**
 * 将两个链表相加
 *
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 原文链接：https://blog.csdn.net/u013270444/article/details/99679599

 总结 ：这个问题自己有个想法：就是讲链表里的每一个节点数据取出，然后组装成一个数字，
       这样两个链表的相加就变成了两个数字的相加，最后再将结果转化成一个链表。
       LeetCode 里也有和我想法一致的，但测试结果会发现内存超了。这个算法的好处就是算法思路简单，但缺点就是复杂度偏高

 说下官方（LeetCode）给的思路：
 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表l1 和l2 的表头开始相加。由于每位数字都应当处于0…9 的范围内，
 我们计算两个数字的和时可能会出现 “溢出”。例如，5+7=12。在这种情况下，我们会将当前位的数值设置为2，并将进位carry=1 带入下一次迭代。
 进位carry 必定是0 或1，这是因为两个数字相加（考虑到进位）可能出现的最大和为9+9+1=19。

 */
public class TowNodePlus {


    public static void main(String[] args){
        SingleNode singleOne1 = new SingleNode(7);
        SingleNode singleOne2 = new SingleNode(0);
        SingleNode singleOne3 = new SingleNode(9);
        singleOne1.next = singleOne2;
        singleOne2.next = singleOne3;

        SingleNode singleTow1 = new SingleNode(3);
        SingleNode singleTow2 = new SingleNode(1);
        SingleNode singleTow3 = new SingleNode(2);

        singleTow1.next = singleTow2;
        singleTow2.next = singleTow3;

        // 结果是 907 + 213 = 1120  （这里面的运算结果还是翻转前的，即0211）
        SingleNode listNode = addTwoNumbers(singleOne1, singleTow1);
        // 打印单链表
        printNode(listNode);
    }

    private static void printNode(SingleNode node){
        while (node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }

    /**
     * 将两个链表相加
     * @param l1 链表一
     * @param l2 链表二
     * @return 新链表
     *
     * 思路如下：
     * 1、将当前结点初始化为返回列表的哑结点
     * 2、将进位carry 初始化为0。
     * 3、将p 和 q 分别初始化为列表l1 和 l2 的头部。
     * 4、遍历列表l1 和 l2 直至到达它们的尾端。
     *    （4.1）将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
     *    （4.2）将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     *    （4.3）设定 sum=x+y+carry。
     *    （4.4）更新进位的值，carry=sum/10。
     *    （4.5）创建一个数值为 (summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     *    （4.6）同时，将 p 和 q 前进到下一个结点。
     * 5、检查 carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     * 6、返回哑结点的下一个结点。
     *
     * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
     * 还要注意三种链表情况：
     * 1、当一个列表比另一个列表长时
     * 2、当一个列表为空时，即出现空列表
     * 3、求和运算最后可能出现额外的进位，这一点很容易被遗忘
     */
    private static SingleNode addTwoNumbers(SingleNode l1, SingleNode l2) {
        SingleNode dummyHead = new SingleNode(0);
        SingleNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new SingleNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new SingleNode(carry);
        }
        return dummyHead.next;
    }

}

