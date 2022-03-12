package Map;

import org.junit.Test;

import java.util.*;

/**
 * @author Christp
 * @version 1.0
 * @ClassName MapTest
 * @Description TODO
 * @date 2021/9/23 11:32
 */

/*
* ——Map:双列集合，用来存储一对一对(key - value)的数据
*   ——HashMap作为Map的主要实现类；线程不安全，效率高；可存储null的key和value
*       ——LinkedHashMap:保证在遍历元素时，可以按照添加的顺序实现遍历
*                       原因:在原有的HashMap底层结构的基础上，添加了类似指针，指向了前一个和后一个元素
*                       对于频繁的遍历操作，LinkedHashMap效率高于HashMap
*   ——TreeMap:保证按照添加的key - value对进行排序，实现排序遍历、
*             底层使用红黑树
*   ——HashTable:作为古老的实现类；线程安全，效率低；不可存储null的key和value
*       ——Properties:常用来处理配置文件。key和value都是String类型
*
* 面试题：
* 1、HashMap的底层实现原理
* 2、HashMap和HashTable的异同
* 3、CurrentHashMap与HashTable的异同
*
* 二、Map结构的理解：
*   Map中的key:无序的，不可重复的，使用Set存储所有的key -->key所在的类要重写hashCode()和equals()方法
*   Map中的value:无序的，不可重复的，使用Collection存储所有的value -->value所在的类要重写equals()方法
*   一个键值对:key - value构成一个entry对象
*   Map中的entry:无序的，不可重复的，使用Set存储所有的entry
*
* 三、HashMap底层实现原理：(jdk 7)
*   HashMap map = new HashMap();
*   在实例化以后，底层创建了长度为16的一维数组entry[] tables
*   ..可能已经执行过多次put..
*   map.put(key1, value1);
*   首先，调用key1躲在的hashCode()计算哈希值，此时哈希值经过某种算法计算后，得到在Entry数组中的存放位置
*   如果此位置上的数据为空，此时的key1 - value1添加成功 ——情况1
*   如果此位置上的数据不为空(表示此位置上存在一个或多个数据(以链表形式存在)),比较key1
*   和已经存在的一个或多个数据的哈希值：
*       如果key1的哈细致与已经存在数据的哈希值不相同，此时的key1 - value1添加成功 ——情况2
*       如果key1的哈细致与已经存在某一个数据的哈希值相同，继续比较:调用key1所在类的equals()方法，比较：
*           如果equals()返回false，此时的key1 - value1添加成功 ——情况3
*           如果equals()返回true，使用value1替换value2
*
* 补充：关于情况2和情况3，此时key1 - value1和原来的数据将以链表的形式存储
* 在不断从增加的过程中，会涉及到扩容问题，当超出临界值时(且要存放的位置非空时)，扩容，默认的扩容方式:扩容为原来的两倍，并将原来的数组复制过来
*
* jdk 8中与7的不同：
* 一、new HashMap():底层没有创建一个长度为16的数组
* 二、jdk 8的底层数组是Node[], 而不是Entry[]
* 三、首次调用put()方法时，底层创建长度为16的数组
* 四、当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当数组的长度 > 64时
*    所有数据改为使用红黑树存储
*
* 四、常用变量
* DEFAULT_INITIAL-CAPACITY:HashMap默认容量：16
* DEFAULT_LOAD_FACTOR:HashMap默认加载因子：0.75
* threshold:扩容的临界值 = 容量*加载因子=0.75*16:12
* TREEIFY_THRESHOLD:Bucket中链表长度大于该数时，转化为红黑树:8
* MIN_TREEIFY_CAPACITY:桶中Node被树化时最小的hash表容量:64
*
* 五、Map中的常用方法：
* 添加、删除、修改操作：
    Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
    void putAll(Map m)：将m中的所有key-value对存放到当前map中
    Object remove(Object key)：移除指定key的key-value对，并返回value
    void clear()：清空当前map中的所有数据
*元素查询的操作：
    Object get(Object key)：获取指定key对应的value
    boolean containsKey(Object key)：是否包含指定的key
    boolean containsValue(Object value)：是否包含指定的value
    int size()：返回map中key-value对的个数
    boolean isEmpty()：判断当前map是否为空
    boolean equals(Object obj)：判断当前map和参数对象obj是否相等
* 元视图操作的方法：
    Set keySet()：返回所有key构成的Set集合
    Collection values()：返回所有value构成的Collection集合
    Set entrySet()：返回所有key-value对构成的Set集
*总结：Map的常用方法
    添加：put(Object key,Object value)
    删除：remove(Object key)
    修改：put(Object key,Object value)
    查询：get(Object key)
    长度：size()
    遍历：keySet() / values() / entrySet()
*
*
* HashMap底层:数组+链表(jdk7 以前)
*            数组+链表+红黑树(jdk 8)
 */

public class MapTest {

    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null, 123);
    }

    @Test
    public void test2(){

        /*
        * 添加、删除、修改操作：
            Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
            void putAll(Map m)：将m中的所有key-value对存放到当前map中
            Object remove(Object key)：移除指定key的key-value对，并返回value
            void clear()：清空当前map中的所有数据
        */

        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("BB", 1213);
        map.put("CC", 453);
        map.put("DD", 153);
        //修改
        map.put("AA", 12);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("EE", 54);
        map1.put("FF", 544);
        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        //返回值为键值对应的value，如果不存在则为null
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());
    }

    @Test
    public void test4(){
        /*
        *元素查询的操作：
            Object get(Object key)：获取指定key对应的value
            boolean containsKey(Object key)：是否包含指定的key
            boolean containsValue(Object value)：是否包含指定的value
            int size()：返回map中key-value对的个数
            boolean isEmpty()：判断当前map是否为空
            boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        */
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("BB", 1213);
        map.put("CC", 453);
        map.put("DD", 153);

        //Object get(Object key)
        System.out.println(map.get("AA"));

        //boolean containsKey(Object key)
        Object key;
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        //boolean containsValue(Object value)
        isExist = map.containsValue("153");
        System.out.println(isExist);

        //isEmpty()
        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test5(){
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("BB", 1213);
        map.put("CC", 453);
        map.put("DD", 153);

        //遍历所有的key值:keySet()
        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }

        //遍历所有的value集:values()
        Collection values = map.values();
        for (Object o: values
             ) {
            System.out.println(o);
        }

        //遍历所有的key - value:
        // 方式一:entrySet()
        Set set1 = map.entrySet();
        for (Object o:set1
             ) {
            System.out.println(o);
        }

        //方式二:
        Set keySet = map.keySet();
        Iterator iterator1 = keySet.iterator();
        while(iterator1.hasNext()){
            Object key = iterator1.next();
            Object value = map.get(key);
            System.out.println(key + "---->" + value);
        }

    }

}