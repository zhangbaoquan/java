package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 读入自然数m和n（0<=m<=n<=1000）,判断分数m/n式有限小数还是循环小数
 */
public class TestDemo {

    public static void main(String[] args) {
        int m;
        int n;
        int yushu;
        int xunhuanwei;
        int zhi;
        for (n = 1; n <= 1000; n++) {
            for (m = 1; m < n; m++) {
                System.out.print(m+"/"+n+"=0.");
                List<Integer> list = new ArrayList<Integer>();
                yushu = m;
                xunhuanwei = 0;
                for (;;) {
                    yushu = yushu * 10;
                    if (list.contains(yushu)) {
                        list.clear();
                        list.add(yushu);
                        xunhuanwei++;
                        if(xunhuanwei==1)
                            System.out.print("(");
                    }
                    list.add(yushu);
                    zhi = yushu / n;
                    yushu = yushu % n;
                    if (xunhuanwei ==2){
                        System.out.print(")");
                        break;
                    }
                    System.out.print(zhi);
                    if (yushu == 0)
                        break;
                }
                System.out.println();
            }
        }
    }
}
