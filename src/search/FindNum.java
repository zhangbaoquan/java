package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindNum {

    public static void main(String[] args) {
//        findNum(new int[]{2, 3, 1, 0, 2, 5, 3});
        findNum2(new int[]{2, 3, 1, 0, 2, 5, 3, 3});
    }

    private static void findNum(int[] num) {
        Set<Integer> temp = new HashSet<>();
        int result = -1;
        for (int i = 0; i < num.length; i++) {
            if (!temp.add(num[i])) {
                result = num[i];
            }
        }
        System.out.print("重复数字 : " + result);
    }

    /**
     * 扩展：查找数组中所有重复的数字，并输出每一个重复数字的重复的次数
     *
     * @param number 数组
     */
    private static void findNum2(int[] number) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : number) {
            if (!map.containsKey(num)) {
                // 首次加入
                map.put(num, 1);
            } else {
                // 有重复的
                int n = map.get(num);
                map.put(num, n + 1);
            }
        }
        for (Integer key : map.keySet()) {
            int b = map.get(key);
            if (b > 1){
                System.out.print("数字 : " + key + ", 重复次数：" + map.get(key));
                System.out.println();
            }
        }
    }

}
