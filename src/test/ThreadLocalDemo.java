package test;

/**
 * @author coffer
 * @Description :
 * @date 2021/5/18 8:35 上午
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocalOne = new ThreadLocal<>();
        ThreadLocal<String> threadLocalTwo = new ThreadLocal<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalOne.set("线程一的数据 --- threadLocalOne");
                threadLocalTwo.set("线程一的数据 --- threadLocalTwo");
                System.out.println(threadLocalOne.get());
                System.out.println(threadLocalTwo.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocalOne.get());
                System.out.println(threadLocalTwo.get());
                threadLocalOne.set("线程二的数据 --- threadLocalOne");
                threadLocalTwo.set("线程二的数据 --- threadLocalTwo");
                System.out.println(threadLocalOne.get());
                System.out.println(threadLocalTwo.get());
            }
        }).start();
    }
}
