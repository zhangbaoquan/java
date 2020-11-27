
/**
 * 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 *  
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fib {

    public static void main(String[] args) {
        System.out.print(fibV2(10));
    }

    /**
     * 这个是最low 的写法。原因是：有大量重复的递归计算,需要各自计算f(n - 2)的值
     *
     * @param n 参数
     * @return 结果
     */
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 使用动态规划算法，将f(n+1) = f(n) + f(n - 1)为转移方程
     *
     * @param n 参数
     * @return
     */
    private static int fibV2(int n) {
        if (n == 0) return 0;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 相当于f2 = f1 + f0;
            dp[i] = dp[i - 1] + dp[i - 2];
            // 这个主要是大数越界
//            dp[i] %= Integer.MAX_VALUE;
            dp[i] %= 1000000007;
        }

        return dp[n];
    }
}
