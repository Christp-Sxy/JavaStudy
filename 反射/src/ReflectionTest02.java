import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ReflectionTest02
 * @Description TODO
 * @date 2021/10/31 12:48
 */

/*
*
*/

public class ReflectionTest02 {
    @Test
    public void test01() throws Exception{
        Class<Persom> clazz = Persom.class;
        //创建运行时类的对象(注意:获取的对象一定要有空的构造函数)
        Persom p = (Persom) clazz.newInstance();

        //获取指定类型的对象:要求运行时类的属性设置为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        * 设置当前属性的值
        *
        * set():参数1:指明设置哪个对象的属性     参数2:将此属性值设置为多少
        */

        id.set(p, 1001);

        /*
        * 获取当前对象的属性值
        * get()L:参数1:获取哪个对象的当前属性值
        */
        int pId = (int)id.get(p);
        System.out.println(pId);
    }

    @Test
    public void testField1() throws Exception {
        /*
        * 如何操作运行时类的指定属性
        */
        Class<Persom> clazz = Persom.class;
        Persom p = clazz.newInstance();

        //getDeclaredField(String fieldName):&#x83B7;&#x53D6;&#x8FD0;&#x884C;&#x65F6;&#x7C7B;&#x6307;&#x5B9A;&#x53D8;&#x91CF;&#x540D;&#x7684;&#x5C5E;&#x6027;
        Field name = clazz.getDeclaredField("name");

        //一定要用setAccessible()，否则的话只能更改类型为public的属性
        name.setAccessible(true);

        name.set(p, "嫩爹");

        System.out.println(name.get(p));
    }

    @Test
    public void testMethod1() throws Exception {
        /*
         * 如何操作运行时类的指定方法
         */
        Class<Persom> clazz = Persom.class;
        Persom p = clazz.newInstance();

        /*
        * 获取指定的某个方法：
        * getDeclaredMethod():参数1:指明获取的方法的名称，参数2:指明获取的方法的形参列表
        */
        Method show = clazz.getDeclaredMethod("showNation", String.class);
        //同上一个调用属性，确保方法可访问
        show.setAccessible(true);

        /*
        * invoke():参数1:方法的调用者   参数2:给方法形参赋值的实参
        * invoke()方法的返回值即为所调用用类中的方法的返回值
        */
        show.invoke(p, "CHN");

        System.out.println("**************调用静态方法****************");
        Method show1 = clazz.getDeclaredMethod("show");
        show1.setAccessible(true);
        //如果调用的运行时类的方法没有返回值，则此invoke()返回null
        show1.invoke(Persom.class);

    }
}