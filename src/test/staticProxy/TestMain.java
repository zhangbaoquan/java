package test.staticProxy;

/**
 * @author coffer
 * @Description :
 * @date 2021/5/17 4:06 下午
 */
public class TestMain {

    public static void main(String args[]){
        UserProxy userProxy = new UserProxy(new UserManagerImpl());
        userProxy.addUser();
        userProxy.deleteUser();
    }
}
