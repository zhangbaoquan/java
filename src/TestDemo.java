

public class TestDemo {

    public static void main(String[] args) {
       System.out.println(recursion(5));
    }

    /**n
     * 递归算法
     */
    private static int recursion(int n){
        if (n==0){
            return 1;
        }else {
            return recursion(n-1)+1;
        }
    }
}
