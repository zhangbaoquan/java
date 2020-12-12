package array;

/**
 * @author coffer
 * @Description :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * @date 2020/12/9 8:10 上午
 */
public class FindMiniNumber {
    public static void main(String[] args) {
        minArray(new int[]{3, 4, 5, 1, 2});
    }

    /**
     * 使用二分查找算法，注意在两个值相同的情况下的比较
     *
     * 时间复杂度：O(log2N)，在特殊情况下（[1,1,1,1]）会变成）O(N)
     * 空间复杂度：O(1),pre、last、cur 变量使用常数大小的额外空间
     *
     * @param numbers 目标数组
     * @return 结果
     */
    private static int minArray(int[] numbers) {
        // 注意，这里的numbers 是排序数组，per 指向数组的最左边，last指向数组的最右边
        int pre = 0, last = numbers.length - 1;
        while (pre != last) {
            int cur = (pre + last) / 2;
            if (numbers[cur] > numbers[last]) {
                // cur 是在左边的排序数组，例如 [3,4,5  ,1,2] ，pre = 3,cur = 5,last = 2
                pre = cur + 1;
            } else if (numbers[cur] < numbers[pre]) {
                // cur 是在右边的排序数组 例如 [1,2,3  ,4,5] ,pre = 1,cur = 3,last = 5
                last = cur;
            } else {
                // 这里表示 numbers[cur] == numbers[pre]，这里无法判断 cur 是在左边还是右边排序数组，
                // 即无法判断旋转点 x是在[per,cur]，还是在[cur+1,last],
                // 自然也就无法使用二分法缩小区间，因为其旋转点不在[pre,last]区间，解决办法，执行last = last -1，缩小判断范围

                // 思考：为啥num[cur]和num[pre] 作比较：
                // 二分法的作用是判断当前cur在哪个排序数组中，从而缩小区间范围。在num[cur] > num[pre] 的情况下无法判断cur在哪个排序数组中，
                // 例如 [3,4,5,1,2] 和 [1,2,3,4,5] ,按照 numbers[cur] > numbers[last] 比较，可以区分前一个在右边数组，
                // 后面一个在左边数组。但按照num[cur] > num[pre] 来分析，都是左边数组
                last --;
            }
        }
        // 返回值是在per == last 时，跳出二分循环，旋转点numbers[pre]
        return numbers[pre];
    }
}
