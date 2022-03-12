/**
 * @author Christp
 * @version 1.0
 * @ClassName Persom
 * @Description TODO
 * @date 2021/10/11 20:39
 */
public class Persom {
    public int age;
    private String name;

    public Persom(int id) {
        this.id = id;
    }

    public int id;

    @Override
    public String toString() {
        return "Persom{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Persom() { }
    public void setName(String name) {
        this.name = name;
    }

    public Persom(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Persom(String name){
        this.name = name;
    }

    public static void show(){
        System.out.println("这是个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}