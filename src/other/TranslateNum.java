package other;

/**
 * @author coffer
 * @Description :把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，
 * 25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/20 5:48 下午
 */
public class TranslateNum {

    /**
     * 使用动态规划算法
     * <p>
     * 步骤分析如下：
     * 状态定义： 设动态规划列表dp[i]代表 xi 以为结尾的数字的翻译方案数量
     * 转移方程： 若 xi 和 xi-1 组成的两位数字可以被翻译，则 dp[i]=dp[i−1]+dp[i−2] ；否则dp[i]=dp[i−1] 。
     * 例如 25 可以翻译成 cf 和 w
     * 可被翻译的两位数区间：当xi−1=0 时，组成的两位数是无法被翻译的（例如00,01,02,⋯ ），因此区间为[10,25]
     * <p>
     * 初始状态：dp[0]=dp[1]=1 ，即 “无数字” 和 “第 1 位数字” 的翻译方法数量均为1
     * 返回值：  dp[n] ，即此数字的翻译方案数量
     * <p>
     * 考虑： 无数字情况 dp[0]=1 从何而来？
     * 解决：当num 第 1,2 位的组成的数字 ∈[10,25] 时，显然应有 2 种翻译方法，即 dp[2]=dp[1]+dp[0]=2 ，
     * 而显然 dp[1]=1 ，因此推出 dp[0]=1 。这里考虑使用字符串遍历方法。
     * 即：
     * （1）为方便获取数字的各位 xi 考虑先将数字num 转化为字符串s ，通过遍历s 实现动态规划。
     * （2）通过字符串切片s[i−2:i] 获取数字组合10xi−1 + xi，通过对比字符串 ASCII 码判断字符串对应的数字区间。
     * （3）空间使用优化： 由于 dp[i] 只与 dp[i−1] 有关，因此可使用两个变量 a,b 分别记录 dp[i],dp[i−1] ，
     * 两变量交替前进即可。此方法可省去 dp 列表使用的 O(N) 的额外空间
     * <p>
     * 时间复杂度：O(N) ,n为字符串s的长度，其决定了循环次数
     * 空间复杂度：O(N)，n 为字符串s使用O(N) 的额外空间
     *
     * @param num 目标数字
     * @return 结果
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        // 设置初始状态
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            // 获取一个字符串切片
            String temp = str.substring(i - 2, i);
            // 对比字符串 ASCII 码判断字符串对应的数字区间
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                // ∈[10,25] 对应的转移状态函数是：dp[i]=dp[i−1]+dp[i−2]
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
