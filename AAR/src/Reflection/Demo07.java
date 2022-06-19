package Reflection;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的信息
 */
public class Demo07 {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("Reflection.Users");
//        System.out.println(c1);
//        Users user = new Users();
//        c1 = user.getClass();

        //类的名字
        System.out.println("类的名字-----------------");
        System.out.println(c1.getName());//包名+类名
        System.out.println(c1.getSimpleName());//简单名字

        //获得类的属性
        System.out.println("类的属性-----------------");
        //只可以可以找到public的属性
        System.out.println("public-----------------");
        Field[] fields = c1.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        //可以找到所有的属性
        System.out.println("all-----------------");
        fields = c1.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        //获得指定属性的值
        System.out.println("类的属性-----------------");
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
//        System.out.println(c1.getField("sex"));

        //获得类的方法
        System.out.println("类的方法------------------------");
        System.out.println("本类和本类继承的public-----------------------");
        Method[] methods = c1.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
        System.out.println("本类的所有方法-------------------");
        methods = c1.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
        System.out.println("获得指定方法----------------------");
        Method getAge = c1.getMethod("getAge");
        Method setName = c1.getMethod("setName",String.class);//后面加方法的参数类型
        System.out.println(getAge);
        System.out.println(setName);

        System.out.println("获得指定的构造器-------------");
        System.out.println("获得public-----------------");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);
        }
        System.out.println("获得全部的构造器------------");
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);
        }
        System.out.println("获得指定的构造器-------------");
        Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
        System.out.println(constructor);
    }
}
