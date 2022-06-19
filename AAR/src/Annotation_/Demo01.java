package Annotation_;

import java.util.ArrayList;

/**
 * 初识注解
 */
public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.test();
    }
    //重写的注解
    @Override
    public String toString() {
        return "Demo01{}";
    }
    //废弃注解，不鼓励程序员使用的，但可以使用，或有更好的方式
    @Deprecated
    public void test(){
        System.out.println("this is deprecated");
    }
    //可以抑制编译时的警告，需要传入参数
    @SuppressWarnings("all")
    public void testt(){
        ArrayList<String> arrayList = new ArrayList<>();
    }
}
