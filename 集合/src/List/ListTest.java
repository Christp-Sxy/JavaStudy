package List;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ListTest
 * @Description TODO
 * @date 2021/9/21 21:43
 */

/*
 * ——ArrayList, LinkedList, Vector
 *   ArrayList:作为List接口的主要实现类(线程不安全，效率高，底层使用Object[]存储)
 *   LinkedList:对于频繁的插入和删除操作，使用此类效率比ArrayList高。(底层使用双向链表存储)
 *   Vector:作为List的古老接口(线程安全，效率低，底层使用Object[]存储)
 *   三者的异同：
 *       同：都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *       不同：见上
 *
 * jdk7中：
 *   ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *   List.add(123);//elementData[0] = new Integer(123)
 *   ...
 *   List.add(123);//如果此次的操作导致数组容量不够则扩容
 *   默认情况下是扩容1.5倍，且会将原来数组的内容复制到新的数组中去
 *   结论：建议开发中使用带参的构造器ArrayList list = new ArrayList(int capacity);
 *
 * jdk8中：
 *   ArrayList list = new ArrayList();//底层创Object[]数组elementData初始化为{}
 *   List.add(123);//第一次添加元素的时候才创建了容量为10的数组，并将123添加到elementData[0]
 *   后续与7中相同
 *
 * 小结：jdk7中ArrayList的对象的创建类似于单例的饿汉式，而jdk8中则类似于懒汉式，
 *       延迟了数组的创建，节省了内存
 *
 * LinkedList源码分析：
 *   LinkedList List = new LinkedList();//内部声明了Node类型的first和last属性，默认为null
 *   List.add(123);//将123封装到Node中，创建了Node对象
 *
 *   其中Node定义为：体现了LinkedList双向链表的特性
 *   private static class Node<E>{
 *       E item;
 *       Node<E> next;
 *       Node<E> prev;
 *
 *       Node(Node<E> prev, E element, Node<E> next){
 *           this.item = element;
 *           this.next = next;
 *           this.prev = prev;
 *      }
 *  }
 */

public class ListTest {
}