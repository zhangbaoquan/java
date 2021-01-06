package string;


/**
 * @author coffer
 * @Description : 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/5 8:26 下午
 */
public class IsNumber {

    /**
     * 实现思路：
     * 1、有限状态自动机，根据字符类型和合法数值的特点，先定义状态，再画出状态转移图，最后编写代码即可。感觉像机器学习，我没搞懂。
     * 2、直接遍历字符串的每一位，并做好标记，这种方案原理就是按照有效数字的规则进行判断
     *
     * @param s 字符串
     * @return 结果
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 去除字符串前后的空格
        s = s.trim();
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false, isDot = false, ise_or_E = false;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                // 标记：遇到了数字
                isNum = true;
            } else if (str[i] == '.') {
                if (isDot || ise_or_E) {
                    // 1、小数点不能重复出现。2、小数点之前不能出现‘e’、'E'
                    return false;
                }
                // 标记：遇到了小数点
                isDot = true;
            } else if (str[i] == 'E' || str[i] == 'e') {
                if (!isNum || ise_or_E) {
                    // 1、E前面必须有数字，2、不能出现两个E
                    return false;
                }
                // 标记：遇到了E
                ise_or_E = true;
                // 注意！重置：isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
                isNum = false;
            } else if (str[i] == '+' || str[i] == '-') {
                // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }
}
