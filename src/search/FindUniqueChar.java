package search;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author coffer
 * @Description : 找出第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @date 2020/11/27 2:41 下午
 */
public class FindUniqueChar {

    public static void main(String[] args) {
        firstUniqChar("loveleetcode");
    }

    public static char firstUniqChar(String s) {
        HashMap<Character,Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            // map中值不重复时，key 的值为true，其他为false
            map.put(value,!map.containsKey(value));
        }
        for(Map.Entry<Character,Boolean> entry : map.entrySet()){
            if (entry.getValue()){
                return entry.getKey();
            }
        }

        return ' ';
    }
}
