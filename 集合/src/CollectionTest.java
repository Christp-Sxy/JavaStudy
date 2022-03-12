import List.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @author Christp
 * @version 1.0
 * @ClassName CollectionTest
 * @Description TODO
 * @date 2021/9/16 16:22
 */

/*
* 一、集合框架的概述
*
* 1.集合、数组都是对多个数据进行存储操作的结构，简称java容器
*   说明：此时的存储，主要是指内存层面的存储，不涉及到持久化存储(.txt, .avi, .jpg, 数据库中)
*
* 2.1 数组在存储多个数据方面的特点：
*     >一旦初始化以后，其长度就确定了
*     >一旦定义好以后，其类型也就确定了，我们只能操作指定类型的数据
*
* 2.2 数组在存储多个数据方面的缺点
*     >一旦初始化以后，其长度就不可修改了
*     >数组提供的方法非常有限，对于增删查改等操作非常的不便，同时效率不高
*     >获取数组中实际元素的个数的需求，数组没有现成的方法或属性可用
*     >数组不能满足存储无序、不可重复的数据
*
* 二、集合的框架
*   ——Collection接口：单列集合，用来存出一个一个的数据
*       ——List接口：存储有序的、可重复的数据   =>“动态”数组
*           ——ArrayList, LinkedList, Vector
*
*       ——Set接口：存储无序的、不可重复的数据   =>数学中的“集合”
*           ——HashSet, LinkedList, TreeSet
*
*   ——Map接口：双列集合，用来存储一对一对(key - value)的数据   =>类似数学的函数
*           ——HashMap, LinkedHashMap, TreeMap, HashTable, Properties
*
* 三、Collection的使用方法
*
* 向Collection接口的实现类对象中添加obj对象时，要重写obj的equals()方法
*/

public class CollectionTest {
    @Test
    public void test001(){
        Collection<Object> collection = new ArrayList<>();
        Person p = new Person("Sxy", 19);

        //add(Object e)：添加元素e到集合中
        collection.add("AA");
        collection.add("BB");
        //自动装箱
        collection.add(123);
        collection.add(p);
        collection.add(new Date());

        //size():获取添加元素的个数
        System.out.println(collection.size());

        //addAll(Collection col)：将col集合中的元素添加到当前集合中
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add("CC");
        coll1.add(456);
        collection.addAll(coll1);
        System.out.println(collection.size());
        System.out.println(collection);

        //clear():清空当前集合的元素
        coll1.clear();

        //isEmpty():判断但钱集合是否为空
        System.out.println(collection.isEmpty());

        //contains(Object obj):判断集合中是否包含obj
        boolean contain = collection.contains(p);
        System.out.println(contain);
        System.out.println(collection.contains(123));

        //containsAll(Collection col1):判断col1中的元素是否都在当前集合中
        Collection<Integer> col1 = Arrays.asList(123, 456);
        System.out.println(coll1.containsAll(col1));



    }
    @Test
    public void test2(){
        //remove(Object obj):从当前集合中移除obj对象
        Collection<Object> collection = new ArrayList<>();
        Collection<Object> coll = new ArrayList<>();
        coll.add("CC");
        coll.add(456);
        coll.remove("CC");
        System.out.println(coll);

        //removeAll(Collection coll):移除当前集合的所有元素

        //retrainAll(Collection coll):求两个集合中相交的部分，并返回给当前集合

        //equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同

    }
}