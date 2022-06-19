package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 动态创建对象，通过反射
 */
public class Demo08 {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("Reflection.Users");

        //构造对象
        Object user = (Users)c1.newInstance();// 调用了User的无参构造，如果没有无参构造会报错
        System.out.println(user);

        //通过构造器构造对象，可以没有无参构造
        Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
        Object user2 = (Users) constructor.newInstance("lin",22,001);
        System.out.println(user2);

        //通过反射调用方法
        Users user3 = (Users) c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getMethod("setName", String.class);
        //invoke激活，
        //（对象，“方法的值”)
        setName.invoke(user3,"zhao");
        System.out.println(user3.getName());

        //通过反射操作属性
        Users user4 = new Users();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭属性的安全检测
        name.setAccessible(true);//默认的false，设为true后关闭属性安全检测
        name.set(user4,"zz");
        System.out.println(user4.getName());
    }
}
