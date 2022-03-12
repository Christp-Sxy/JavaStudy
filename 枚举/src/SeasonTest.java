/**
 * 一、 枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的，我们称此类为枚举类
 * 2.当要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类只有一个对象时，则可以作为单例模式的实现方式
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：之后可以用enum关键字定义枚举类
 *
 * 三、enum类中的常用方法：
 *      values()方法，返回枚举类型的对象数组，该方法可以很方便的遍历所有的枚举值
 *      valueOf(String str)：可以把一个字符串转为对应的美剧类对象，要求字符串必须是枚举类型的对象
 *      toString()：但会当前枚举类对象常量的名称
 *
 * @author Christp
 * @version 1.0
 * @ClassName SeasonTest
 * @Description TODO
 * @date 2021/9/11 10:23
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season autumn = Season.AUTUMN;
        Season winter = Season.WINTER;
        System.out.println(spring);
        System.out.println(summer);
        System.out.println(autumn);
        System.out.println(winter);

    }
}

/*
* 自定义枚举类
* */

/**
 * @author Christp
 * @Description
 * @date 11:02 2021/9/11
 **/
record Season(String seasonName, String seasonDesc) {
    /**
     * 2.私有化类的构造器,并给对象属性赋值
     */
    Season {
    }

    /**
     * 3.提供当前枚举类的多个对象:public static final
     */
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "烈日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "水落石出");

    /**
     * 其他诉求1：获取枚举类对象的属性
     */
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /**
     * 其他诉求2：提供toString()方法
     */
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


