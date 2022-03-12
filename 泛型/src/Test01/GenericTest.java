package Test01;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Christp
 * @version 1.0
 * @ClassName GenericTest
 * @Description TODO
 * @date 2021/9/28 19:29
 */

/*
* 泛型的使用
* 1、jdk 5.0新增的特性
*
* 2、在集合中使用泛型
* 总结：
* ①集合接口或集合类在jdk5.0时都修改为带泛型的结构
* ②在实例化具体集合时可以指明具体的泛型类型
* ③在指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如方法、构造器、属性等)使用到类的接口的泛型的位置，都指定为实例化泛型的类型
*   比如add(E e) ---> 实例化后变为add(Integer e)
* ④注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，拿包装类替换
* ⑤如果实例化时没有指明泛型的类型，默认类型为java.lang.Object类型
*
* 3、如何自定义泛型结构：泛型类，泛型接口，泛型方法
*
* 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
*         换句话说，泛型方法所属的类是不是泛型都没有关系
* 泛型方法，可以声明为静态，原因：泛型参数是在调用方法时确定的，并非在实例化类时确定的
*/

public class GenericTest {
    //在集合中使用泛型的情况
    @Test
    public void test01(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(123);
        arrayList.add(975);
        arrayList.add(18);
        arrayList.add(54);
        arrayList.add(1541);
        //编译时，会进行数据的类型检查，保证数据安全

        //方式一
//        for (Integer integer:arrayList
//             ) {
//            //避免了强转操作
//            int stuScore = integer;
//
//            System.out.println("数字" + stuScore);
//        }

        //方式二
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println("数字" + iterator.next());
        }
    }

    //通配符的使用：?

    //类A是类B的父类，G<A>和G<B>是没有关系的，二者的共同父类是:G<?>

    //List<?>带有通配符的链表是不能添加元素的，除了null之外
    //上面那玩意儿允许读取数据，读取的数据类型为Object

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);
    }

    public void print(List<?> list){
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    /*
    * 有限制的通配符的使用
    *   ? extends Person;
    *       G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类
    *   ? super Person;
    *       G<? super A>可以作为G<A>和G<B>的父类，其中A是B的子类
    */

    @Test
    public void test02(){

    }


}