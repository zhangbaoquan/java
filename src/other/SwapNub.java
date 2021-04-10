package other;

/**
 * @author coffer
 * @Description :
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * https://leetcode-cn.com/problems/swap-numbers-lcci/
 * @date 2021/4/10 3:32 下午
 */
public class SwapNub {

    public static void main(String[] args) {
       int[] n = swap(new int[]{0,1});
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
    public static int[] swap(int[] n){
        n[0] ^= n[1];
        n[1] ^= n[0];
        n[0] ^= n[1];
        return n;
    }
}
