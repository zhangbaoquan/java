package com.arithmetic_list;

import java.util.Stack;

/**
 * 通过两个栈实现一个队列
 */
public class QueueWithStack {
    /**
     * 使用栈stackIn存入数据，再利用stackOut取出数据
     */
    public static Stack<Object> stackIn = new Stack<>();
    public static Stack<Object> stackOut = new Stack<>();

    /**
     * 存入数据
     *
     * @param object
     */
    public static void setData(Object object) {
        stackIn.push(object);
        System.out.println("压入栈元素：" + object);
    }

    public static void getData() {
        if (!stackOut.empty()) {
            System.out.println("弹出入栈元素：" + stackOut.pop());
        } else {
            // 将stackIn里的数据转移至stackOut中，从反转元素顺序
            if (!stackIn.empty()) {
                while (!stackIn.empty()) {
                    Object data = stackIn.pop();
                    stackOut.push(data);
                }
                System.out.println("弹出入栈元素：" + stackOut.pop());
            } else {
                throw new RuntimeException("队列为空");
            }
        }
    }
}
