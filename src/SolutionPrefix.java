/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 */
public class SolutionPrefix {

    public static void main(String[] args) {
        String prefix = searchPublicPrefix(new String[]{"flower","flow","flight"});
        System.out.print(prefix);
    }

    /**
     * 找出最长的公共前缀
     * 这里最关键的方法就是利用字符串的 indexOf（） 方法，即返回指定子字符串第一次出现的字符串中的索引，
     * 如果当前字符串包含该指定的字符串（和contains（） 的区别，indexOf（）是从字符串的左边开始比较）
     * 包含该字符串，返回值是0。不包含该字符串，返回值是-1。
     * 算法的关键点：
     * 1、寻找到长度最短的字符串：例如flow，将他设定为原始公共前缀，
     * 2、遍历字符串数组，找到不包含该字符串的目标字符串，例如：flight。
     * 3、将目标字符串截取掉最后一个字符，例如将flow ——> flo ,继续和刚刚比较的字符串例如flight使用indexOf（），
     *    直到值 = 0时，跳出比较，截取到的最终目标字符串就是数组里都包含的，也就是公共前缀，例如：fl
     *
     * @param strs 原始数组
     * @return 最长的前缀
     */
    private static String searchPublicPrefix(String[] strs){
        // 1、去除脏数据
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        // 2、找数组中最短的那个字符串，因为公共前缀必须以最短的那个字符串作为基准，先以第一个作为基准比较
        int shortIndex = 0;
        String shortStr = "";
        int firstStrLenth = strs[0].length();
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            if (strs[i].length() < firstStrLenth){
                shortIndex = i;
            }
        }
        shortStr = strs[shortIndex];
        // 3、寻找公共前缀
        for (int i = 0; i < len; i++) {
            while (strs[i].indexOf(shortStr) != 0){
               shortStr = shortStr.substring(0,shortStr.length() - 1);
            }
            if (shortStr.equals("")){
                break;
            }
        }

        return shortStr;
    }
}
