package array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的"正整"
 *
 * 输入: [1,2,0]
   输出: 3

   输入: [3,4,-1,1]
   输出: 2

   输入: [7,8,9,11,12]
   输出: 1

   要求：算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 */
public class FindMissNub {


    public static void main(String[] args) {
//        int[] nub = new int[]{7,8,9,11,12,4,1,2,2,3,3};
        int[] nub2 = new int[]{1,2,3,4,5,4,4};
        System.out.print(firstMissingPositive2(nub2));
    }

    /**
     * 使用哈希表的方式，但希表的大小与数组的长度是线性相关的,因此空间复杂度不符合要求
     * 时间复杂度：O(n)，n是数组的长度，第一次遍历了数组的长度，
     * 空间复杂度：O(n)，n是数组的长度。
     * @param nums 目标数组
     * @return 结果
     */
    private static int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = set.size();
        for (int i = 1; i <length; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        // 这里有个问题，网上的算法就是在找不到的时候，使用数组长度 +1是错的，例如nub2，数组中有重复的，
        // 因为默认情况下数组并未有序，就会有问题。因此，如果数组中没有找到，就应该找出数组中最大的那个，并+1
        Arrays.sort(nums);
        return nums[nums.length-1] + 1;
    }

    /**
     * 使用二分查找算法，先将数据排序，然后再做查找
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums 目标数组
     * @return 结果
     */
    private static int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (-1 == binarySearch(nums,i)){
                // -1 表示没有找到
                return i;
            }
        }
        return nums[nums.length-1] + 1;
    }

    /**
     * 二分查找
     * @param nums 目标数组
     * @param target 目标值
     * @return 结果
     */
    private static int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left <= right){
            // >>> 1 表示除以2
            int mid = (right + left) >>> 1;
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }

        return -1;
    }

    private static int firstMissingPositive3(int[] nums) {

        int len = nums.length;
        for(int i = 0; i < len; i++){
       /*
       只有在 nums[i] 是 [1, len] 之间的数，并且不在自己应该呆的位置， nums[i] != i + 1 ，
        并且 它应该呆的位置没有被同伴占有（即存在重复值占有）	nums[nums[i] - 1] != nums[i] 的时候才进行交换

        为什么使用 while ？ 因为交换后，原本 i 位置的 nums[i] 已经交换到了别的地方，
        交换后到这里的新值不一定是适合这个位置的，因此需要重新进行判断交换
        如果使用 if，那么进行一次交换后，i 就会 +1 进入下一个循环，那么交换过来的新值就没有去找到它该有的位置
         比如 nums = [3, 4, -1, 1] 当 3 进行交换后， nums 变成 [-1，4，3，1]，
         此时 i == 0，如果使用 if ，那么会进入下一个循环， 这个 -1 就没有进行处理
        */
            while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
