package Annotation_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
public class Demo03 {
    //注解可以显式赋值，如果没有默认值，就必须赋值
    @MyAnnotation(name = "lin",age = 22,girls = {"zhao","yq"})
    public void test01(){
    }

    @MyNewAnnotation({"zz"})
    public void test02(){
    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //注解的参数：参数类型 + 参数名 + ()
    String name() default "";//可以带默认值
    int age();
    int id() default -1;//如果默认值为-1，代表可以没有
    String[] girls();
}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyNewAnnotation{
    //如果只有一个参数，建议用value命名，这样在传入参数时可以不写 value =
    String[] value();
}