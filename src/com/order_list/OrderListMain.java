package com.order_list;

import java.util.Scanner;

public class OrderListMain {
    public static void main(String[] args) {
        // 定义顺序表变量
        SLType sl = new SLType();

        System.out.println("顺序表操作演示，开始！");

        sl.initData(sl);
        System.out.println("顺序表初始化完成！");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入添加的节点（学号、姓名、年龄）");
            Data myData = new Data();
            myData.key = scanner.next();
            myData.name = scanner.next();
            myData.age = scanner.nextInt();
            if (myData.age != 0) {
                if (sl.addEndData(sl, myData) == 0) {
                    // 若添加节点失败，则退出死循环
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("顺序表中的节点顺序为：\n");
        sl.showAll(sl);

        System.out.println("输入要取出的节点序号：\n");
        int position = scanner.nextInt();
        Data data = sl.findByData(sl, position);
        if (data != null) {
            System.out.printf("第%d个节点为：(%s,%s,%d)\n", position, data.key, data.name, data.age);
        }

        System.out.println("输入要查找的节点关键字");

        String key = scanner.next();
        // 按关键字查找，返回节点序号
        position = sl.findByCount(sl,key);

        // 按序号查找，返回节点的引用
        data = sl.findByData(sl,position);
        if (data != null){
            System.out.printf("第%d个节点为：(%s,%s,%d)\n", position, data.key, data.name, data.age);
        }

    }
}
