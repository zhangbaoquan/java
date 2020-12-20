package other;

import java.util.Stack;

/**
 * @author coffer
 * @Description : 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020/12/20 9:35 下午
 */
public class StackSequences {

    /**
     * 判断出栈和入栈是否匹配
     * 过程：
     * 1、遍历push，将push的数据压入辅助栈
     * 2、取一个辅助栈的栈顶的元素和pop栈的第一个元素比较，如果相等，则出栈，否则继续压栈，逐个比较后面的元素
     * 3、如果push 和pop 数组对应的上，则上述遍历操作后，辅助栈的应该是空的
     *
     * 时间复杂度：O(N) 即push数组的长度
     * 空间复杂度：O(N) 即辅助栈的存储的元素数量
     * @param pushed 入栈
     * @param popped 出栈
     * @return 结果
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed){
            stack.push(num);
            while (!stack.empty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
