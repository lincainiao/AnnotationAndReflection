package Reflection;

import java.awt.*;
import java.lang.reflect.Method;
import java.security.PublicKey;

/**
 * 分析性能
 */
public class Demo09 {
    public static void main(String[] args) throws Exception{

        Users users1 = new Users();
        Class c1 = Class.forName("Reflection.Users");
        long startTime = System.currentTimeMillis();

        //普通方式调用
        for (int i = 0; i < 1000000000; i++) {
            users1.getName();
        }
        System.out.println(System.currentTimeMillis() -startTime);

        //反射方式调用
        startTime = System.currentTimeMillis();
        Method getName = c1.getMethod("getName");
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(users1);
        }
        System.out.println(System.currentTimeMillis()-startTime);

        //反射方式调用，关闭检测
        startTime = System.currentTimeMillis();
        Method getName1 = c1.getMethod("getName");
        getName1.setAccessible(true);//关闭检测
        for (int i = 0; i < 1000000000; i++) {
            getName1.invoke(users1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
