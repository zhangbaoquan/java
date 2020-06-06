package node;

/**
 * 链表Demo
 * 算法分析：查找的时空复杂度是0(n)【双指针】
 * 插入、删除等基本操作的时空复杂度是O(1)
 */
public class BasicDoubleNode {

    private static class Node {
        int data;  // 数据域
        Node next; // 后置指针
        Node pre;  // 前置指针

        Node(int data) {
            this.data = data;
        }
    }

    private Node head; // 链表的头指针
    private int size;  // 链表的实际长度

    /**
     * 链表的插入操作，需要考虑三种情况，头、中间、尾以及空链表
     *
     * @param data  数据
     * @param index 索引
     */
    private void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点的范围！");
        }
        Node node = new Node(data);
        if (size == 0) {
            // 1、空链表
            node.pre = head;
            head = node;
        } else if (index == 0) {
            // 2、插入头节点
            node.next = head;
            head = node;
        } else if (index == size) {
            // 3、插入尾节点
            Node node1 = getNode(index-1);
            node1.next = node;
            node.pre = node1;
        } else {
            // 中间插入
            Node node2 = getNode(index - 1); // 当前节点的前一个节点
            Node node3 = getNode(index); // 当前节点的后一个节点
            node2.next = node;
//            node.next = node3.pre;
        }
        size++;
    }

    /**
     * 查找元素
     *
     * @param index 索引
     * @return
     */
    private Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 输出链表数据
     */
    private void out(){
        Node node = head;
        while (node!= null){
            System.out.print(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        BasicDoubleNode basicNode = new BasicDoubleNode();
        basicNode.insert(1,0);
        basicNode.insert(2,0);
        basicNode.insert(3,0);
        basicNode.insert(4,3);
//        basicNode.insert(5,1);
        basicNode.out();
    }
}
