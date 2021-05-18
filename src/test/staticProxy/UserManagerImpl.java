package test.staticProxy;

/**
 * @author coffer
 * @Description :
 * @date 2021/5/17 4:00 下午
 */
public class UserManagerImpl implements UserManager{
    @Override
    public void addUser() {
        System.out.println("addUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");
    }
}
