import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Christp
 * @version 1.0
 * @ClassName FieldTest
 * @Description TODO
 * @date 2021/10/14 20:41
 */

/*
* 获取当前运行时类的属性结构
*/

public class FieldTest {

    @Test
    public void test01(){
        Class<Persom> clazz = Persom.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中访问权限声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field f: fields
             ) {
            System.out.println(f);
        }

        System.out.println();


        //getDeclaredFields():获取当前运行时类中声明的所有属性，但不包括父类中声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields
        ) {
            System.out.println(f);
        }
    }

    @Test
    public void test02(){
        Class<Persom> clazz = Persom.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields
        ) {
            //1.权限修饰符
            int modifier = clazz.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type + "\t");
            //3.变量名
            System.out.print(f.getName());
            System.out.println();
        }
    }

}