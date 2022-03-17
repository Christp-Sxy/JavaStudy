package Set;

import List.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Christp
 * @version 1.0
 * @ClassName TreeSetTest
 * @Description TODO
 * @date 2021/9/23 10:35
 */
public class TreeSetTest {

    /*
     * 1、向TreeSet中添加的数据，要求是相同类的对象
     * 2、两种排序方式：自然排序和定制排序
     * 3、自然排序中，比较两个对象是否相同的标准为：compareTo()的返回值是否为0，而不是用equals()方法
     * 4、定制排序中，比较两个对象是否相同的标准为：compareTo()的返回值是否为0，而不是用equals()方法
     */

    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        /*
        失败：不同类的数据不能添加到TreeSet中
        set.add(123);
        set.add(513);
        set.add(new Person("SD", 15));
        set.add("AA");
        set.add(456);*/

        set.add(123);
        set.add(1);
        set.add(45);
        set.add(4151);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("数据类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new Person("Cherry", 18));
        set.add(new Person("Berry", 18));
        set.add(new Person("svc", 18));
        set.add(new Person("Julio", 18));
        for (Object o : set) {
            System.out.println(o);
        }
    }
}