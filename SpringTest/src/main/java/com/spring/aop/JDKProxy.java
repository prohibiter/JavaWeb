package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy{
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(new UserDaoImpl()));
        int res = dao.add(1, 2);
        System.out.println(res);
    }
}


//创建代理对象代码
class UserDaoProxy implements InvocationHandler{

    //1、把创建的是谁的代理对象，把谁传递过来
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    //增强的逻辑
    //三个参数为：1、代理对象；2、当前方法；3、参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前执行
        System.out.println("方法之前执行。。" + method.getName() + "：传递的参数..." + Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("方法之后执行：" + obj);


        return null;
    }
}
