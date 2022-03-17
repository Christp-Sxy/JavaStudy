/**
 * @author Christp
 * @version 1.0
 * @ClassName SeasonTest1
 * @Description TODO
 * @date 2021/9/13 12:27
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString()方法
        System.out.println(summer.toString());

        //values();
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
    }
}

enum Season1 {
    /**
     * 提供当前类的对象,多个对象之间用","来隔开，末位的对象用";"
     */
    SPRING("春天", "春暖花开") {
        /**
         * 每个枚举类对象都可以重写一个接口
         */
        @Override
        public void show() {
            System.out.println("我带你们打");
        }
    },
    SUMMER("夏天", "烈日炎炎") {
        @Override
        protected void show() {

        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        protected void show() {

        }
    },
    WINTER("冬天", "水落石出") {
        @Override
        protected void show() {

        }
    };

    /**
     * 2.声明Season对象的属性，用private final来修饰
     */
    private final String seasonName;
    private final String seasonDesc;

    /**
     * 3.私有化类的构造器，并给对象属性赋值
     */

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /**
     * 4.其他诉求1：获取枚举类对象的属性
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
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    protected abstract void show();
}