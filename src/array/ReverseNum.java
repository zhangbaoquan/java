package array;


/**
 * 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
   链接：https://leetcode-cn.com/problems/reverse-integer


    总结：这个问题的最初考虑使用数组去记录当前计算出来的数字的每一位，然后翻转，至于边界问题，想的也复杂了，
         下面的写法将空间复杂度降到了最低（不用去新建数组去开销内存）
 */
public class ReverseNum {

    public static void main(String[] args) {
        System.out.println(reverse(-513));
    }

    /**
     * 反转数据
     * num % 10 ; 可以取出任意一个数的个位（最右边的数）
     * num /= 10; 取完个位后，取出上一级例如51里的5，101里的0.利用while循环可以依次取到最左边的数
     *
     * @param num 输入数据
     */
    private static int reverse(int num) {

        int result = 0;
        while (num != 0) {
            // 将num的个位数（使用取余的方式）依次取出
            int d = num % 10;
            num /= 10;

            // 设置临界条件，
            // 判断最大值时，利用最大值除以10，然后判断余数是否大于7，因为最大值是‭2147483647‬，
            // 判断最小值时，利用最小值除以10，然后判断余数是否小于-8，因为最小值是-‭2147483648
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && d > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && d < -8)) return 0;

            // 组装：每一次就是上次的余数 * 10 + 本次的余数(不用考虑负数)，实现数据反转
            result = result * 10 + d;
        }
        return result;
    }
}
