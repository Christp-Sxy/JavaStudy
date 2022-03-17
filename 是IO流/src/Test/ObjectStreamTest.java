package Test;

import org.junit.Test;

import java.io.*;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ObjectStreamTest
 * @Description TODO
 * @date 2021/10/6 18:52
 */

/*
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型或对象的处理流，
 * 3.要想一个java类可序列化，需要满足一些要求，详情见Person.java
 * 4.Java序列化就是将一个对象转化为一个二进制表示的字节数组，
 *   通过保存或则转移这些二进制数组达到持久化的目的。要实现序列化，
 *   需要实现java.io.Serializable接口。
 *   反序列化是和序列化相反的过程，就是把二进制数组转化为对象的过程。
 *   在反序列化的时候，必须有原始类的模板才能将对象还原。
 *   从这个过程我们可以猜测到，序列化过程并不想class文件那样保存类的完整的结构信息。
 */

public class ObjectStreamTest {

    /*
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     */

    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("VVV.dat"));

            oos.writeObject(new String("wdnmd"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("马牛逼", 35));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 反序列化：将磁盘中文件的对象还原为内存中的一个java对象
     * 使用ObjectInputStream来实现
     */

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("VVV.dat"));

            Object object = ois.readObject();
            String str = (String) object;
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}