package Reflection;

/**
 * 测试类什么时候会初始化
 */
public class Demo05 {
    static {
        System.out.println("this is main");
    }

    public static void main(String[] args) throws Exception{
        //主动引用
//        Son son = new Son();

        //通过反射产生主动引用
//        Class c1 = Class.forName("Reflection.Son");

        //不会主动产生类的引用方法
        //通过子类访问父类的静态常量，不会导致子类被初始化
//        System.out.println(Son.b);
        //通过数组定义类引用
//        Son[] sons = new Son[5];
        //调用常量
        System.out.println(Son.M);
    }
}


class Father{
    static int b = 2;
    static {
        System.out.println("this is father.");
        System.out.println(b);
    }
}

class Son extends Father{
    static {
        System.out.println("this is son");
    }
    static int m = 100;
    static final int M = 1;
}