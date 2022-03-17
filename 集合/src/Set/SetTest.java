package Set;

import List.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Christp
 * @version 1.0
 * @ClassName SetTest
 * @Description TODO
 * @date 2021/9/22 17:59
 */

/*
 * ——Set接口：存储无序的、不可重复的数据   =>数学中的“集合”
 *   ——HashSet:作为Set接口的主要实现类；线程不安全的；可以存储null值
 *       ——LinkedList:作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *   ——TreeSet:可以按照添加对象的指定属性进行排序
 *
 * 1、Set接口中没有额外定义的方法，使用的都是Collection中声明过的方法
 *
 * 要求：1、向Set中添加的数据，其所在的类一定要重写hashCode()和equals()方法
 *      2、重写的hashCode()和equals()尽可能保持一致性，相等的对象必须具有相同的散列码
 */

public class SetTest {

    /*
     * 一、Set接口：存储无序的、不可重复的数据：
     * 1、无序性：不等于随机性。存储的数据在底层数组并非按照索引的顺序去添加，而是按照数据的哈希值来进行排序
     *
     * 2、不可重复性：只能存储地址不一样的数据
     *
     * 二、添加元素的过程，以HashSet为例：
     *   我们向HashSet添加元素a, 首先调用a所在类的HashCode()方法，计算a的Hash值
     *   此Hash值接着通过某种算法计算出在HashSet()底层数组中的存放位置(即索引位置)
     *   判断数组此位置是否有元素：
     *       如果此位置上没有其他元素，则元素a添加成功-->情况1
     *       如果此位置上存在其他元素(或以链表形式存在多个元素)，则比较元素a与元素b的
     *       Hash值
     *           如果Hash值不同，则元素a添加成功-->情况2
     *           如果Hash值相同，进而需要调用元素a所在类的equals()方法：
     *               equals()返回true，元素a添加失败；
     *               equals()返回false，元素a添加成功；-->情况3
     *
     * 对于添加成功的情况2和情况3而言，元素a已经存在指定的索引位置上了，数据以链表的方式存储
     * jdk 7：元素a放到数组中，指向原来的元素
     * jdk 8：原来的元素在数组中，指向元素a
     * 总结：七上八下
     *
     * HashSet底层为数组+链表的结构
     */


    //HashSet的使用
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(513);
        set.add(new Person("SD", 15));
        set.add("AA");
        set.add(456);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    /*
     * LinkedHashset的使用:
     * LinkedHashSet作为HashSet的子类，添加数据的同时，每个数据还维护了两个引用
     * 记录此数据的前一个数据和后一个数据
     * 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */

    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(513);
        set.add(new Person("SD", 15));
        set.add("AA");
        set.add(456);
        for (Object o : set) {
            System.out.println(o);
        }
    }
}