package Annotation_;

import java.lang.annotation.*;

/**
 * 自定义元注解
 */
public class Demo02 {
    @TryAnnotation
    public void test(){
    }
}
//定义一个注解
//Target表示：ElementType.METHOD表示该注解用在方法上，ElementType.Type可以用到类等其他上面
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention表示我们的的注解在哪个地方有效
//RUNTIME>CLASS>SOURCES
@Retention(value = RetentionPolicy.RUNTIME)
//Documented表示是否将注解生成JAVAdoc中
@Documented
//Inherited表示子类可以继承父类的注解
@Inherited
@interface TryAnnotation{}
