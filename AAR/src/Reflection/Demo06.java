package Reflection;

public class Demo06 {
    public static void main(String[] args) throws Exception{
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载的父类加载器-->扩展类加载器你
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类的父类加载器-->根加载器(C/C++)，无法直接获得
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader aClassLoader = Class.forName("Reflection.Demo06").getClassLoader();
        System.out.println(aClassLoader);
        //测试JDK内置的类是哪个加载器
        aClassLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(aClassLoader);

        //如何获得系统加载类可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
