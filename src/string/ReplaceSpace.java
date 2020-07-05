package string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        replaceSpace2(s);
    }

    /**
     * 替换字符串里的字符。
     * 注意：由于每次替换从 1 个字符变成 3 个字符，所以数组长度需要是字符串的3倍
     * 时间复杂度是 循环了一遍字符串，因此是O(n)，空间复杂度是原来三倍的空间 即O(n)
     * @param s 字符串
     */
    private static void replaceSpace(String s) {
        int len = s.length();
        int currentSize = 0; // 当前数组的长度
        char[] chars = new char[len * 3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                chars[currentSize++] = '%';
                chars[currentSize++] = '2';
                chars[currentSize++] = '0';
            }else {
                chars[currentSize++] = c;
            }
        }
        String str = new String(chars,0,currentSize);
        System.out.print(str);
    }

    /**
     * 也可以使用字符串原生的替换方法
     * @param s 字符串
     */
    private static void replaceSpace2(String s) {
        String string = s.replaceAll(" ", "%20");
        System.out.print(string);
    }

}
