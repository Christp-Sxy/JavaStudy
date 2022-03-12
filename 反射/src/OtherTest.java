import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Christp
 * @version 1.0
 * @ClassName OtherTest
 * @Description TODO
 * @date 2021/10/31 12:07
 */

/*
*
*/

public class OtherTest {
    @Test
    public void test01(){
        //getConstructors():获取当前运行时类申明为public的构造器
        Class<Persom> clazz = Persom.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c:
             constructors) {
            System.out.println(c);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c:
                declaredConstructors) {
            System.out.println(c);
        }
    }

    @Test
    public void test02(){
        //获取当前运行时类的父类
        Class clazz = Persom.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }


    @Test
    public void test03(){
        //获取当前运行时类泛型的父类
        Class clazz = Persom.class;
        Type superclass = clazz.getGenericSuperclass();
        System.out.println(superclass);
    }


    @Test
    public void test04(){
        //获取当前运行时类泛型的父类的泛型
        Class clazz = Persom.class;
        Type superclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type t:
             actualTypeArguments) {
            System.out.println(t.getTypeName());
        }
    }

    @Test
    public void test05(){
        Class clazz =Persom.class;
        //获取当前运行时类的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class c:
             interfaces) {
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c:
                interfaces1) {
            System.out.println(c);
        }
    }


    @Test
    public void test06() {
        Class clazz = Persom.class;
        //获取运行时类所在的包
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
}