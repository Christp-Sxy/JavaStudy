package List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Christp
 * @version 1.0
 * @ClassName IteratorTest
 * @Description TODO
 * @date 2021/9/21 21:21
 */

/*
* 结合元素的遍历操作，使用迭代器Iterator接口
*/

public class IteratorTest {
    @Test
    public void test1(){
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add("CC");
        coll1.add(456);
        coll1.add(123);
        coll1.add(485);

        Iterator<Object> iterator = coll1.iterator();
//      方式一：
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
//        报异常，NoSuchElementException
        System.out.println(iterator.next());

//        方式二：(不推荐)
//        for (int i = 0; i < coll1.size() ; i++) {
//            System.out.println(iterator.next());

//        方式三：(推荐)
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
    @Test
    public void test2() {
        Collection<Object> coll2 = new ArrayList<>();
        coll2.add("AA");
        coll2.add(456);
        coll2.add(123);
        coll2.add(485);

        Iterator<Object> iterator = coll2.iterator();
        //删除集合中的123元素
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("123".equals(obj)){
                iterator.remove();
            }

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        }
    }
}