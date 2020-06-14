package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * <p>
 * <p>
 * “回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，
 * 就“回溯”返回，尝试别的路径。回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。
 * 但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
 * 这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
 * <p>
 * 回溯算法和递归算法的区别：回溯算法指的是一种思想，而递归算法则是指代码层面上的一种组织结构
 */
public class SolutionBracket {

    public static void main(String[] args) {
        List<String> data = generateBracket(2);
        int size = data.size();
        for (int i = 0; i < size; i++) {
            System.out.println(data.get(i));
        }
    }

    private static List<String> generateBracket(int n) {
        List<String> list = new ArrayList<>();
        generate(n, n, "", list);
        return list;
    }

    private static void generate(int left, int right, String content, List<String> result) {
        if (left == right && left == 0) {
            result.add(content);
        }
        if (right > left) {
            generate(left, right - 1, content+")", result);
        }
        // 先从左边开始加"("
        if (left > 0) {
            generate(left - 1, right, content+"(", result);
        }
    }
}
