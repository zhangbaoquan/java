package array;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * <p>
 * 例如：
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 输入: [2,2,1,1,1,2,2]  n/2 = 3，2出现了4次
 * 输出: 2
 */
public class MoreNumber {

    public static void main(String[] args) {
        int nub[] = new int[]{1, 1, 0, 3, 2, 2, 2, 1, 2};
        System.out.print(majorityElement(nub));
    }

    /**
     * 方法1、使用摩尔投票算法
     * <p>
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     * <p>
     * 时间复杂度：O(n)，仅需要遍历一次数组
     * 空间复杂度：1  ，不需要额外的辅助空间
     *
     * @param nums 目标数组
     * @return 结果
     */
    private static int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int pos = nums[0]; // 第一个候选人
        int count = 1; // 票数
        for (int i = 1; i < nums.length; i++) {
            if (pos == nums[i]) {
                // 遇到相同的，票数+1
                ++count;
            } else if (--count == 0) {
                // 候选人没有票了，换下一个候选人
                pos = nums[i];
                count = 1;
            }
        }
        return pos;
    }

    /**
     * 方法2、使用排序的办法
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为[n/2]的元素（下标从 0 开始）一定是众数。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     *
     * 时间复杂度：O(nlogn)，排序时间
     * 空间复杂度：1  ，不需要额外的辅助空间
     *
     * @param nums 目标数组
     * @return 结果
     */
    private static int majorityElement2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

    /**
     * 方法3、使用哈希表
     * 我们使用哈希映射（HashMap）来存储每个元素以及出现的次数。
     * 对于哈希映射中的每个键值对，键表示一个元素，值表示该元素出现的次数。
     * 我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。
     * 在这之后，我们遍历哈希映射中的所有键值对，返回值最大的键。
     * 我们同样也可以在遍历数组 nums 时候使用打擂台的方法，维护最大的值，这样省去了最后对哈希映射的遍历。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     来源：力扣（LeetCode）
     * @param nums 目标数组
     * @return 结果
     */
    private static int majorityElement3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Map<Integer,Integer> map = getMap(nums);
        Map.Entry<Integer,Integer> major = null;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (major == null || entry.getValue() > major.getValue()){
                major = entry;
            }
        }
        return major.getKey();

    }

    private static Map<Integer,Integer> getMap(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length -1; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        return map;
    }

}
