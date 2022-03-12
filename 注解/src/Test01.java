import java.time.Period;

/**
 * @author Christp
 * @version 1.0
 * @ClassName Test01
 * @Description TODO
 * @date 2021/9/14 13:56
 */



public class Test01 {
    public static void main(String[] args) {
        Person p = new Students();
        p.walk();
    }
}

class Person{

    public Person(){

    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    /**
    * 这个接口屁用没有
    * @author Christp
    * @Description 啥也不干
    * @date 14:08 2021/9/14
    * @param x int
    **/
    public void show(int x);
}

class Students extends Person implements Info{
    /**
    * @author Christp
    * @Description
    * @date 14:06 2021/9/14
    **/
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show(int x) {
        System.out.println(1);
    }
}