package List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ArrayListTest
 * @Description TODO
 * @date 2021/9/22 15:14
 */

/*
 * Add方法用于添加一个元素到当前列表的末尾
 * AddRange方法用于添加一批元素到当前列表的末尾
 * Remove方法用于删除一个元素，通过元素本身的引用来删除
 * RemoveAt方法用于删除一个元素，通过索引值来删除
 * RemoveRange用于删除一批元素，通过指定开始的索引和删除的数量来删除
 * Insert用于添加一个元素到指定位置，列表后面的元素依次往后移动
 * InsertRange用于从指定位置开始添加一批元素，列表后面的元素依次往后移动
 * Clear方法用于清除现有所有的元素
 * Contains方法用来查找某个对象在不在列表之中
 * TrimSize方法用于将ArrayList固定到实际元素的大小，
 *         当动态数组元素确定不在添加的时候，可以调用这个方法来释放空余的内存。
 * ToArray方法把ArrayList的元素Copy到一个新的数组中。
 *
 * int indexOf(Object obj)返回obj在集合中首次出现的位置
 * Object get(int index)获取指定index位置的元素
 * int lastIndexOf(Object obj)返回obj在集合中末次出现的位置
 * Object set(int index, Object obj)将index位置的元素替换成obj
 * list sublist(int fromIndex, int toIndex)返回从fromIndex到toIndex的子集合
 */

public class ArrayListTest {
    @Test
    public void test1() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("SB", 21));
        list.add(456);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "BB");

        //boolean addAll(int index, Collection col)从index位置开始将集合中的所有元素添加到集合中
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);

        System.out.println(list);
    }
}