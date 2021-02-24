package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author coffer
 * @Description :
 * @date 2021/1/27 8:34 下午
 */
public class HeapSort {

    public static void main(String []args){
//        int []arr = {4,6,8,5,9};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        heapSort2();
    }
    public static void heapSort(int []arr){
        // 1.构建大顶堆，从第一个非叶子结点从下至上，从左至右调整结构，该节点的位置是
        // 下面的for循环里的语句意思是：第一个非叶子结点的位置是： arr.length/2-1，然后从左开始
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 自定义比比较器
     */
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 升序
//            return o1 - o2;
            // 降序
            return o2 - o1;
        }
    };

    /**
     * 使用优先队列PriorityQueue是Queue接口的实现。数据关键词按照有序顺序排列。
     * PriorityQueue是基于优先堆（二叉堆）的一个无界队列，
     * 这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。
     * 要求使用Java Comparable和Comparator接口给对象排序，并且在排序时会按照优先级处理其中的元素。
     *
     */
    private static void heapSort2(){
        Queue<Integer> queue = new PriorityQueue<>();
        int []arr = {4,6,8,5,9};
        for(int num : arr){
            queue.add(num);
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }

}
