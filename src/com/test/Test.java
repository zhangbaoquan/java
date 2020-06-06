package com.test;

public class Test {

    private final static int INIT_FLAG_THIRD_LOGIN		= 0x01;
    private final static int INIT_FLAG_SPLASH			= 0x02;
    private final static int INIT_FLAG_APP				= 0X04;
    private final static int INIT_FLAG_NET_WARN         = 0x08;

    public static void main(String[] args) {

        String str = "http://ah2.zhangyue.com/zybook/u/p/book.php?key=4B4";
        del(str);

    }

    public static void del(String str) {
        if (str.contains("key=")){
            int index = str.indexOf("key=");
            String s = str.substring(index + 4,index + 5);
            int num = Integer.parseInt(s);

//            System.out.println(index);
//            System.out.println(str.length());
//            System.out.println(s);

            int n1 = num | INIT_FLAG_THIRD_LOGIN;
//            System.out.println(n1);
            int n2 = num & INIT_FLAG_THIRD_LOGIN;
//            System.out.println(n1);
            int n3 = num | INIT_FLAG_NET_WARN;
//            System.out.println(n1);
            int n4 = num & INIT_FLAG_NET_WARN;
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);
            System.out.println(n4);

        }
    }

}
