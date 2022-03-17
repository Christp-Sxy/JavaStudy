import org.junit.Test;

import java.util.Random;

/**
 * @author Christp
 * @version 1.0
 * @ClassName NewInstanceTest
 * @Description TODO
 * @date 2021/10/14 20:17
 */

/*
 * 通过发射创建对应的运行时类的对象
 */

public class NewInstanceTest {

    @Test
    public void test01() throws InstantiationException, IllegalAccessException {
        Class<Persom> clazz = Persom.class;
        //newInstance()：调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器
        /*
         * 要想此方法正常地创建运行时类的对象，要求：
         * 1.运行时类必须提供空参的构造器
         * 2.空参的访问权限要足够，一般设置为public
         *
         *
         * 在javabean中要求提供一个public的空参构造器，原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Object obj = clazz.newInstance();
        System.out.println(obj);


    }

    @Test
    public void test02() {
        int num = new Random().nextInt(3);
        String classPath = switch (num) {
            case 0 -> "java.util.Date";
            case 1 -> "java.long.Object";
            case 2 -> "Persom";
            default -> throw new IllegalStateException("Unexpected value: " + num);
        };

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
     * 创建一个指定类的对象
     * classpath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}