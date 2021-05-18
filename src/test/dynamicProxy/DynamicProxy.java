package test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author coffer
 * @Description : 动态代理类只能代理接口（不支持抽象类），代理类都需要实现InvocationHandler类，实现invoke方法。
 *                该invoke方法就是调用被代理接口的所有方法时需要调用的，该invoke方法返回的值是被代理接口的一个实现类
 * @date 2021/5/17 8:49 下午
 */
public class DynamicProxy implements InvocationHandler {
    // 目标对象
    private Object mObjectTarget;

    public Object newProxyInstance(Object targetObject){
        this.mObjectTarget = targetObject;
        // 将将targetObject包装到实现了InvocationHandler接口的DynamicProxy对象中。
        // 通过newProxyInstance函数我们就获得了一个动态代理对象。
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start-->>");
        if (args != null){
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
            }
        }
        Object ret=null;
        try{
            // 原对象方法调用前处理日志信息
            System.out.println("satrt-->>");
            //调用目标方法
            if (args != null){
                ret=method.invoke(mObjectTarget,args);
            }else {
                ret=method.invoke(mObjectTarget);
            }
            // 原对象方法调用后处理日志信息
            System.out.println("success-->>");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error-->>");
            throw e;
        }
        return ret;
    }
}
