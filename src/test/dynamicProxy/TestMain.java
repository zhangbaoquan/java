package test.dynamicProxy;

/**
 * @author coffer
 * @Description :
 * @date 2021/5/17 4:23 下午
 */
public class TestMain {
    public static void main(String args[]){
        DynamicProxy proxy = new DynamicProxy();
        UserManager userManager = (UserManager) proxy.newProxyInstance(new UserManagerImpl());
        userManager.addUser();
    }
}
