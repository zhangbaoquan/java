package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args){

        String str = "I am noob from - runoob.com";
//        String regex=".*from.*";
//        containStr(str);

        countStr();
        replaceStr2();
        containNumber();
    }

    /**
     * 【包含】判断目标字符串里是符合某一个规则
     * @param content 内容
     */
    private static void containStr(String content){
        boolean status;
        // .* .*  是通配符
        String regex = ".*-.*";
        // 　Matcher 对象是对输入字符串进行解释和匹配操作的引擎
        status = Pattern.matches(regex,content);
        System.out.println("是否包含 ： "+status);
    }

    /**
     * 【统计】一个字符串在大字符串里出现的次数
     */
    private static void countStr(){
       // 规则
       String regex = "\\bcat\\b";
        // 在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。
       String content ="cat cat cat cattie cat";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(content);
       int count = 0;
       while (matcher.find()){
           count ++;
       }
       println(count);
    }

    private static void replaceStr2(){
        // 规则，将字符中含有b、ab
        String regex = "a*b";
        String content ="afoaabfoabfoobkkkobpbppbpba";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String str = matcher.replaceAll("-");
        println(str);
    }
    private static void println(Object content){
        System.out.println(content);
    }

    /**
     * 【包含】判断目标字符串里是否包含数字
     */
    private static void containNumber(){
        boolean status;
        // 这个表示一个字符串是否是纯数字
//        String regex = "^[0-9]*$";
        // 这个表示一个字符串是否包含数字
        String regex = ".*\\d+.*";
        String content = "0哈哈";
        // 　Matcher 对象是对输入字符串进行解释和匹配操作的引擎
        status = Pattern.matches(regex,content);
        System.out.println("是否包含数字 ： "+status);
    }
}
