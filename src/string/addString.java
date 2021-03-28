package string;

/**
 * @author coffer
 * @Description : 两个字符串相加
 * 例 ：
 * s1 = "51189"，s2 = "967895"  ，和为"1019084"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/12 2:14 下午
 */
public class addString {

    public static void main(String[] args) {
        System.out.println(addStrings("51189","967895"));
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
//            int n1 = i >= 0 ? num1.charAt(i) : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
//            int n2 = j >= 0 ? num2.charAt(j) : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
