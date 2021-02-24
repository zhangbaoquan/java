package search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author coffer
 * @Description :
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/24 10:15 下午
 */
public class FindMiniNumbers {

    public static void main(String[] args) {
        int nub[] = new int[]{0,4,6,3,1,5,7};
//        int[] k = getLeastNumbers(nub,2);
//        for (int i = 0; i < k.length; i++) {
//            System.out.println(k[i]);
//        }
        heapSort(nub,2);

    }

    /***
     * 这题考察的就是排序算法的使用
     *
     * 注意找前 K 大/前 K 小问题不需要对整个数组进行 O(NlogN) 的排序！
     * 例如本题，直接通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数啦～
     * @param arr 目标数组
     * @param k 切分位
     * @return 结果
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * 快速排序
     * @param nums 待排序的数组
     * @param start 起始位
     * @param end 结束位
     * @param k 找的是下标为k-1的数
     * @return 结果
     */
    private static int[] quickSearch(int[] nums, int start, int end, int k) {
        // 每快排切分1次，找到排序后下标为j的元素
        int j = partition(nums, start, end);
        if (j == k) {
            // 如果j(切分位)恰好等于k就返回j以及j左边所有的数；
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, start, j - 1, k): quickSearch(nums, j + 1, end, k);
    }

    /**
     * 分治（使用单边循环法）【还有一个双边循环法，逻辑太绕，单边简单清晰】
     * 1、选定一个基准元素，默认可以是start，区间位，默认和基准元素位置一样
     * 2、遍历数组，小于基准元素时，mark 向右移动一位，然后将当前位置元素和mark位置元素交换位置
     * 3、遍历完成后，在将mark 元素值放在原先基准元素的位置，再将基准元素的值赋值到原先mark的位置
     * @param nums 待交换的数组
     * @param start 起始位置
     * @param end 结束位置
     * @return 结果
     */
    private static int partition(int[] nums, int start, int end) {
        // 取第一元素作为基准元素
        int pivot = nums[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot){
                mark ++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }


    /**
     * 使用堆排序
     * @param arr 目标数组
     * @param k 最小的个数
     */
    private static void heapSort(int[] arr,int k){
        // 默认是升序
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : arr){
            queue.add(num);
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = queue.poll();
        }
        for (int n : temp) {
            System.out.println(n);
        }
    }


}
