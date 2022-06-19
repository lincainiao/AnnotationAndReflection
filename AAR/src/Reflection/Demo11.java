package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射操作注解ORM
 */
public class Demo11 {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("Reflection.Girls");

        //通过反射获得注解
//        Annotation[] annotations = c1.getAnnotations();
//        for (Annotation annotation:annotations) {
//            System.out.println(annotation);
//        }
        //获得注解value的值
        tableGirls tableGirls = (Reflection.tableGirls) c1.getAnnotation(Reflection.tableGirls.class);
        String value = tableGirls.value();
        System.out.println(value);

        //获得类指定的注解
        Field field = c1.getDeclaredField("name");
        fieldGirls annotation = field.getAnnotation(fieldGirls.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());
    }
}

@tableGirls("db_girls")
class Girls{
    @fieldGirls(columName = "db_id",type = "int",length = 10)
    private int id;
    @fieldGirls(columName = "db_age",type = "int",length = 10)
    private int age;
    @fieldGirls(columName = "db_name",type = "varchar",length = 3)
    private String name;

    public Girls(){

    }
    public Girls(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface tableGirls{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface fieldGirls {
    String columName();
    String type();
    int length();
}
