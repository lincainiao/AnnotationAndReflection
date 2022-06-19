package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型
 */
public class Demo10 {
    public static void main(String[] args) throws Exception{
        Method method01 = Demo10.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method01.getGenericParameterTypes();//获取泛型参数类型
        for (Type genericParameterType:genericParameterTypes) {
            System.out.println(genericParameterType);//只能获得Map和List，无法获得Map和List里面的类型
            if (genericParameterType instanceof ParameterizedType){//判断是否是参数化类型，如Map<Integer>
                //强制转换，获取真实类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument:actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        System.out.println("----------------------");

        Method method2 = Demo10.class.getMethod("test02");
        Type genericParameterType = method2.getGenericReturnType();//获取返回类型
        if (genericParameterType instanceof ParameterizedType){//判断是否是参数化类型，如Map<Integer>
            //强制转换，获取真实类型
            Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
            for (Type actualTypeArgument:actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }

    static public void test01(Map<String,Users> map, List<Users> list){
        System.out.println("this is 01");
    }

    static public Map<String, Users> test02(){
        System.out.println("this is 02");
        return null;
    }
}
