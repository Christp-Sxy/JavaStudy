package Test;

import java.io.Serializable;

/**
 * @author Christp
 * @version 1.0
 * @ClassName Person
 * @Description TODO
 * @date 2021/10/6 19:26
 */

/*
* Person需要满足如下的要求，方可序列化
* 1.需要可实现接口Serializable
* 2.当前类提供一个全局常量：serialVersionUID
* 3.除了当前Person类需要实现一个Serializable接口之外，还必须保证其内部所有属性
*   也必须是可序列化的(默认情况下，基本数据类型可序列化)
*
* 补充：ObjectInputStream和ObjectOutputStream不能序列化static和transient修饰的成员变量
*/

public class Person implements Serializable {
    public static final long serialVersionUID = 42312313121L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}