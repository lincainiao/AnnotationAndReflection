package Reflection;

/**
 1、加载到内存，产生Class对象
 2、链接，链接结束后m = 0
 3、初始化
    <clinit>(){
        System.out.println("A的静态初始化");
        m = 500;
 }
    m = 100;
    </clinit>
 */
public class Demo04 {
    public static void main(String[] args) {
        A a = new A();
        Demo04 test = new Demo04();
//        System.out.println(a.m);
    }
}

class A{
//    static int m = 100;
    static int m;
    public A(){
        System.out.println("A的无参初始化");
        m = 100;
        System.out.println(m);
    }
    static {
        System.out.println("A的静态初始化");
        m = 500;
        System.out.println(m);
    }

}
