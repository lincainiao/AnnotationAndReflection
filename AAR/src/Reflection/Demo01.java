package Reflection;

import javax.xml.validation.TypeInfoProvider;

/**
 * 反射
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
        //通过反射获取类的class对象
        Class c1 = Class.forName("Reflection.Users");
        System.out.println(c1);
//        Class c2 = Class.forName("Reflection.User");
//        Class c3 = Class.forName("Reflection.User");
        //一个类在内存中只有一个class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中，
        System.out.println(c1.hashCode());
//        System.out.println(c2.hashCode());
//        System.out.println(c3.hashCode());
    }
}