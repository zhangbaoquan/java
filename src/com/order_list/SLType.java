package com.order_list;

/**
 * 定义顺序表结构，包含线性表的基本运算
 * 描述：初始化、计算表长、获取节点、查找节点、插入节点、删除节点
 */
public class SLType {

    /**
     * 定义表的最大长度
     */
    static final int MAXLEN = 100;

    /**
     * 保存顺序表的结构数组
     */
    Data[] listData = new Data[MAXLEN + 1];

    /**
     * 顺序表已存节点的数量
     */
    private int listLen;

    /**
     * 初始化顺序表
     *
     * @param sl
     */
    public void initData(SLType sl) {
        sl.listLen = 0;
    }

    /**
     * 获取顺序表的元素数量
     *
     * @param sl
     * @return
     */
    public int getListLen(SLType sl) {
        return sl.listLen;
    }

    /**
     * 将数据插入到顺序表中，成功返回1，失败返回0
     *
     * @param sl
     * @param position
     * @param data
     * @return
     */
    public int insertData(SLType sl, int position, Data data) {
        if (sl.listLen >= MAXLEN) {
            System.out.println("顺序表已经满了，不能再插入节点了");
            return 0;
        }
        if (position < 1 || position > sl.listLen - 1) {
            System.out.println("插入的元素位置有误，不能再插入元素");
            return 0;
        }

        for (int i = sl.listLen; i < position; i++) {
            // 将顺序表中的数据向后移动
            sl.listData[i + 1] = sl.listData[i];
        }

        // 插入节点，并将顺序表节点数量增加1
        sl.listData[position] = data;
        sl.listLen++;
        return 1;
    }

    /**
     * 将数据插入到顺序表中的尾部
     *
     * @param sl
     * @param data
     * @return
     */
    public int addEndData(SLType sl, Data data) {
        if (sl.listLen >= MAXLEN) {
            System.out.println("顺序表已经满了，不能再插入节点了");
            return 0;
        }
        sl.listData[++sl.listLen] = data;
        return 1;
    }

    /**
     * 删除数据表中的某个数据元素
     *
     * @param sl
     * @param position
     * @return
     */
    public int deleteData(SLType sl, int position) {
        if (position < 1 || position > sl.listLen + 1) {
            System.out.println("删除节点的序号错误，不能删除该节点了");
            return 0;
        }
        for (int i = position; i < sl.listLen; i++) {
            // 将顺序表中的元素向前移动
            sl.listData[i] = sl.listData[i + 1];
        }
        sl.listLen--;
        return 1;
    }

    /**
     * 根据元素序号，返回该数据元素
     *
     * @param sl
     * @param position
     * @return
     */
    public Data findByData(SLType sl, int position) {
        if (position < 1 || position > sl.listLen + 1) {
            System.out.println("节点序号错误，不能返回该节点了");
            return null;
        }
        return sl.listData[position];
    }

    /**
     * 根据关键字查找节点
     *
     * @param sl
     * @param key
     * @return
     */
    public int findByCount(SLType sl, String key) {
        for (int i = 1; i <= sl.listLen; i++) {
            if (sl.listData[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        // 搜索整个表都没有找到，则返回0
        return 0;
    }

    /**
     * 显示顺序表中的所有节点
     *
     * @param sl
     * @return
     */
    public int showAll(SLType sl) {
        for (int i = 1; i <= sl.listLen; i++) {
            System.out.printf("(%s,%s,%d)\n", sl.listData[i].key, sl.listData[i].name, sl.listData[i].age);
        }
        return 1;
    }
}
