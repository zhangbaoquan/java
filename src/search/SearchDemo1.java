package search;

/**
 * 算法-------二分法查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class SearchDemo1 {

    public static void main(String[] args) {
        int index = searchIndex(new int[]{0,1,2,3,4,9},9);
        System.out.print(index);
    }

    /**
     * 使用二分查找，找到目标数在数组中对应的下标，找不到时，返回-1
     *
     * @param num    数组
     * @param target 目标数
     * @return 下标
     */
    private static int searchIndex(int num[], int target) {
        int left = 0;
        int right = num.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (num[mid] == target){
                return mid;
            }else if (num[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }


}
