package array;


/**
 *
 * <p>
 * 求一个数的2进制1 的个数
 * <p>
 * 示例 输入任意一个数，输出这个数的二进制1 的个数
 *
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 */
public class HasCount {

    public static void main(String[] args) {
        System.out.println(hammingWeight(3));
    }

    /**
     * 时间复杂度：逐位判断需要循环log2n 次，即 O(log2n)
     * 空间复杂度：O(1)
     * @param n 目标数
     * @return 1 的个数
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
//            n /= 2;
        }
        return res;
    }

}
