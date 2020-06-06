package array;

/**
 * 数组Demo
 * 插入、删除、扩容等基本操作
 * 算法分析：读取、更新、查找元素的时间、空间复杂度是O(1)
 * 插入、删除、扩容的时间、空间复杂度是O(n)
 * 关于删除，有两种做法，一种就是逐个移动元素删除，还有就是要删除的元素替换，然后删除最后一项。前一种做法的时空复杂度是O(n),后者是O(1)
 */
public class BasicArray {

    private int[] array;
    private int size; // 数组实际元素的数量

    /**
     * @param capacity 数组的容量
     */
    private BasicArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 扩容，将老的数组空间扩展2倍，将老数组的内容复制到新数组中，并指向新数组
     */
    private void expandCapacity() {
        int[] newArray = new int[array.length * 2];
        // 将旧数组的内容复制到新的数组中
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 插入数据，注意扩容的情况
     *
     * @param element 元素
     * @param index   索引位置
     */
    private void insertData(int element, int index) {
        // 判断元素是否越界
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组元素插入越界啦");
        }
        // 如果当前元素的数量多于数组的空间，则需要给当前的数组扩容
        if (size >= array.length) {
            expandCapacity();
        }
        // 从右向左循环，将元素逐个向右边挪一个
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        // 将元素插入
        array[index] = element;
        size++;

    }

    /**
     * 删除元素，做法就是将数组的最后一个元素复制到要删除的位置上，然后删除最后一个元素，时空复杂度是O(1)
     *
     * @param index 元素的索引
     */
    private void deleteData2(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组元素插入越界啦");
        }
        array[index] = array[array.length -1];
        size--;
    }

    /**
     * 删除元素，逐个移动元素的位置，时空复杂度是O(n)
     *
     * @param index 索引
     */
    private void deleteData(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组元素插入越界啦");
        }
        // 从左向右循环，将元素逐个向左移动
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }


    public void out() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        BasicArray array = new BasicArray(5);
        array.insertData(1, 0);
        array.insertData(2, 0);
        array.insertData(3, 0);
        array.insertData(4, 0);
        array.insertData(5, 0);
        array.insertData(6, 5);
        array.deleteData(5);
        array.deleteData2(0);
        array.out();
    }
}
