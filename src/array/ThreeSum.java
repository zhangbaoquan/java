package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public static void main(String[] args) {

    }

    /**
     * 思路：排序 + 双指针
     * 1、若nums[i]>0 ，因为是排好序的，所以三个数加起来一定大于0
     * 2、若前后两个元素相同，则跳过，避免结果重复
     *
     * 时间复杂度：O(n2) 即：数组排序：nlogn , 外层遍历n ,双指针遍历 n ,总共nlogn + （n * n）= n2
     * 空间复杂度：O(1)
     *
     * @param nums 目标数组
     * @return 结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> data = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 1、若nums[i]>0 ，因为是排好序的，所以三个数加起来一定大于0
                return null;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 2、若前后两个元素相同，则跳过，避免结果重复
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[right]);
                    list.add(nums[left]);
                    data.add(list);
                    // 去重，判断左右边界是否和下一个数重复，将当前数的左右两边相同的数全部去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    // 表明nums[right] 太大，应该向左移动
                    right--;
                } else {
                    left++;
                }
            }
        }
        return data;
    }
}
