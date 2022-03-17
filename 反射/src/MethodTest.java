import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Christp
 * @version 1.0
 * @ClassName Methid
 * @Description TODO
 * @date 2021/10/31 11:39
 */

/*
 * 获取运行时类的方法结构
 */

public class MethodTest {
    @Test
    public void test01() {
        Class<Persom> clazz = Persom.class;

        //getMethods():获取当前运行时类及其父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }

        System.out.println();

        //getDeclaredMethods():获取当前运行时类中所有的方法(不包含父类中的 )
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m :
                declaredMethods) {
            System.out.println(m);
        }

    }


    /*
     * 获取类的内部结构
     * @Xxxx
     * 权限修饰符 返回值类型 方法名(参数类型1 形参名1, ....) throws XxxException{}
     */
    @Test
    public void test02() {
        Class<Persom> clazz = Persom.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m :
                declaredMethods) {
            //1.获取当前方法的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a :
                    annotations) {
                System.out.println(a);
            }

            //2.获取权限修饰付
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + "args_" + i + ",");
                }
            }

            System.out.println();
        }

    }
}