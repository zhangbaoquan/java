package test.staticProxy;

/**
 * @author coffer
 * @Description :
 * @date 2021/5/17 4:03 下午
 */
public class UserProxy implements UserManager{

    private UserManagerImpl mUserManagerImpl;

    public UserProxy(UserManagerImpl userManager){
        this.mUserManagerImpl = userManager;
    }

    @Override
    public void addUser() {
        System.out.println("啦啦😝");
        mUserManagerImpl.addUser();
    }

    @Override
    public void deleteUser() {
        System.out.println("哈哈😄");
        mUserManagerImpl.deleteUser();
    }
}
