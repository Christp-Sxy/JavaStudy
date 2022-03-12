import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ReflectionTest
 * @Description TODO
 * @date 2021/10/11 20:38
 */

/*
*
*/

public class ReflectionTest {

    //反射之前对于Persom类的操作
    @Test
    public void test01(){
        //创建Persom类对象
        Persom p1 = new Persom(12, "Tmo");
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();
        /*
        * Persom类外部，不能通过Persom类的对象调用其内部私有结构
        * 比如name, showNation()以及私有类的构造器
        */
    }

    //反射之后，对于Persom的操作
    @Test
    public void test02() throws Exception, IllegalAccessException, NoSuchFieldException {
        Class<Persom> cla = Persom.class;
        //1.通过反射，创建Persom类的对象
        Constructor<Persom> cons = cla.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Christp", 19);
        Persom p = (Persom) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = cla.getDeclaredField("age");
        age.set(p, 3);
        System.out.println(p.toString());

        //调用方法
        Method show = cla.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Persom类的私有结构的，比如私有构造器、方法、属性
        //调用私有的构造器
        Constructor<Persom> cons1 = cla.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Persom p1 = (Persom) cons1.newInstance("Fuck");
        System.out.println(p1);

        //调用私有的属性
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "wdnmd");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = cla.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "China");//相当于p1.showNation("China");

    }

    //获取Class的实例方式
    @Test
    public void test03() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Persom> clazz = Persom.class;
        System.out.println(clazz);

        //方式二：通过运行时的类，调用.getClass()
//        Persom p2 = new Persom();
//        Class<? extends Persom> clazz2 = p2.getClass();
//        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String pathname)
        Class<?> clazz3 = Class.forName("Persom");
//        clazz3 = Class.forName("java.long.String")
        System.out.println(clazz3);

        //方式四：实用类的加载:ClassLoader(了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("Persom");

    }
}