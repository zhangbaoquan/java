package other;

/**
 * @author coffer
 * @Description : 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @date 2020/11/27 3:13 下午
 */
public class PrintNNumber {

    /**
     * 方法一
     * 分析：
     * 1、最大N位数（记为end）和N的关系 ： end = 10 ^ N - 1
     * 2、大数越界问题： 当 n 较大时，int32 整型的取值范围，超出取值范围的数字无法正常存储。
     * 但由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。
     * 因此，只需定义区间[1 , 10 ^ N -1]  和步长 1 ，通过 for 循环生成结果列表 res 并返回即可
     * 时间复杂度：O(10 ^n)
     * 空间复杂度：O(1)
     * <p>
     * 注意，这个题目重点考察的是大数的处理，这个解法在面试中强烈不推荐，因为没有难度而言
     *
     * @param n 位数
     * @return 结果数组
     */
    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i + 1;
        }
        return result;
    }


    public static void main(String[] args) {
//        printNumbers(3);
        Solution solution = new Solution();
        solution.printNumbers(3);
    }

    static class Solution {

        /**
         * 方法二
         * 大数打印解法。本题的主要考点是大数越界情况下的打印
         * <p>
         * 分析：
         * 1、无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型。
         * 2、使用 int 类型时，每轮可通过 +1 生成下个数字，而此方法无法应用至 String 类型。并且，
         * String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次。
         * 观察可知，生成的列表实际上是n 位0 - 9 的 全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表。
         * 3、基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。例如当
         * n=2 时（数字范围 1 − 99）固定十位为0 - 9，按顺序依次开启递归，固定个位0 -9 ，终止递归并添加数字字符串。
         *
         * @param n 位数
         * @return 结果数组
         */
        public int[] printNumbers2(int n) {
            nb = n;
            int c = (int) Math.pow(10, n) - 1;
            res = new int[c];
            num = new char[n];
            start = n - 1;
            dfs(0);
            return res;
        }

        int[] res;
        int nine = 0, count = 0, start, nb;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        void dfs(int x) {
            if (x == nb) {
                String s = String.valueOf(num).substring(start);
                if (!s.equals("0")) res[count++] = Integer.parseInt(s);
                if (nb - start == nine) start--;
                return;
            }
            for (char i : loop) {
                if (i == '9') nine++;
                num[x] = i;
                dfs(x + 1);
            }
            nine--;
        }

        /**
         * 输出字符串，处理起来要比转
         * @param n 长度
         * @return 结果
         */
        public String printNumbers(int n) {
            nb2 = n;
            sb = new StringBuilder(); // 数字字符串集
            num2 = new char[n]; // 定义长度为 n 的字符列表
            dfs2(0); // 开启全排列递归
            sb.deleteCharAt(sb.length() - 1); // 删除最后多余的逗号
            return sb.toString(); // 转化为字符串并返回
        }

        StringBuilder sb;
        int nb2;
        char[] num2, loop2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        void dfs2(int x) {
            if(x == nb2) { // 终止条件：已固定完所有位
                sb.append(String.valueOf(num2)).append(","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
                return;
            }
            for(char c : loop2) { // 遍历 ‘0‘ - ’9‘
                num2[x] = c; // 固定第 x 位为 i
                dfs2(x + 1); // 开启固定第 x + 1 位
            }
        }
    }

}
