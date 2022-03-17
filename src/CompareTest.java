import java.util.Arrays;

/**
 * @author Christp
 * @version 1.0
 * @ClassName CompareTest
 * @Description TODO
 * @date 2021/9/9 17:18
 */
public class CompareTest {
    /*
    Comparable接口使用
    1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了两个比较大小的结果
    2.像String、包装类等实现了Comparable接口，重写了compareTo()方法，进行了从小到大的排序
    3.重写compareTo()的规则
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回0。
    Comparator接口使用
    4.重写compare(Object obj1, Object obj2)的规则,比较obj1和obj2的大小
        如果obj1大于obj2，则返回正整数，
        如果obj1小于obj2，则返回负整数，
        如果obj1等于obj2，则返回0

    对比Comparable和Comparator
    前者是类里面自己的一个接口可以使用，而后者则是临时定义的一个方法，
    */

    /**
     * @author Christp
     * @Description
     * @date 17:27 2021/9/9
     **/
    public void test() {
        String[] arr = new String[]{"AA", "BB", "CC", "GG"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}