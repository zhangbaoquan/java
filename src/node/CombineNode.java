package node;


/**
 * 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class CombineNode {

    public static void main(String[] args) {
        SingleNode node1 = crateOrderNode(1,3,5);
        SingleNode node2 = crateOrderNode(2,4,6);

        printNode(combineNode(node1,node2));

    }

    /**
     * 创建一个有序的链表
     * @param a 1
     * @param b 2
     * @param c 3
     * @return 新链表
     */
    private static SingleNode crateOrderNode(int a, int b, int c) {
        SingleNode node1 = new SingleNode(a);
        SingleNode node2 = new SingleNode(b);
        SingleNode node3 = new SingleNode(c);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    /**
     * 合并两个有序的链表
     * @param l1 1
     * @param l2 2
     * @return 新链表
     */
    private static SingleNode combineNode(SingleNode l1,SingleNode l2){
        SingleNode dum = new SingleNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;

    }

    private static void printNode(SingleNode node){
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

}
