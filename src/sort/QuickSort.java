package sort;

/**
 * @author coffer
 * @Description :
 * @date 2021/4/11 4:36 下午
 */
public class QuickSort {

    /**
     * 快速排序
     * @param nums 待排序的数组
     * @param startIndex 起始位
     * @param endIndex 结束位
     * @return 结果
     */
    private static void quickSearch(int[] nums, int startIndex, int endIndex) {
        // 递归结束条件：
        if (startIndex >= endIndex){
            return;
        }
        // 获取基准元素
        int pivotIndex = partition(nums,startIndex,endIndex);
        // 根据基准元素，分成两个部分进行递归排序
        quickSearch(nums,startIndex,pivotIndex - 1);
        quickSearch(nums,pivotIndex+1,endIndex);
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
}
