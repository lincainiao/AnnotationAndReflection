package Reflection;

/**
 * 测试Class类的创建方式
 */
public class Demo02 {
    public static void main(String[] args) throws Exception{
        Students student = new Students();
        System.out.println("this is "+student.getName());

        //方法一：通过对象获得
        Class c1 = student.getClass();
        System.out.println(c1.hashCode());

        //方法二：forName获得
        Class c2 = Class.forName("Reflection.Students");
        System.out.println(c2.hashCode());

        //方法三：通过类名.class获得
        Class<Students> c3 = Students.class;
        System.out.println(c3.hashCode());

        //方法四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.class;
        System.out.println(c4);
        System.out.println(c4.hashCode());

        //获得父类的类型
        Class superclass = c1.getSuperclass();
        System.out.println(superclass);

    }
}
