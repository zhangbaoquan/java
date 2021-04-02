package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author coffer
 * @Description :
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @date 2021/3/31 4:10 下午
 */
public class AssemblyString {

    public static void main(String[] args) {
        permutation("abc");
        System.out.println();
    }

    static List<String> list = new LinkedList<>();
    static char[] c;
    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    static void dfs(int x){
        if (x == c.length -1){
            // 添加排列方案
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])){
                // 去除重复的，剪枝
                continue;
            }
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                   // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }

    }

    static void swap(int a,int b){
        char t = c[a];
        c[a] = c[b];
        c[b] = t;
    }
}
