package Test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author Christp
 * @version 1.0
 * @ClassName RandomAccessFileTest
 * @Description TODO
 * @date 2021/10/6 21:04
 */

/*
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.long.Object类，实现了DataInput和dataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *   如果写出到的文件不存在，则会对原有文件进行覆盖(是从文件开头进行覆盖)
 * 4.可以通过相关操作实现对RandomAccessFile的插入效果
 */

public class RandomAccessFileTest {

    @Test
    public void test01() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("jojo.jpg", "r");
            raf2 = new RandomAccessFile("jojo1.jpg", "r");

            byte[] buff = new byte[1024];
            int len;
            while ((len = raf1.read(buff)) != -1) {
                raf2.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置处
        raf1.write("xsy".getBytes(StandardCharsets.UTF_8));

        raf1.close();

    }

    /*
     * 使用RandomAccessFile实现数据的插入效果
     */

    @Test
    public void test03() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");

            raf1.seek(3);//将指针调到角标为3的位置处

            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buff = new byte[20];
            int len;
            //保存位置3指针后的所有数据于StringBuilder中
            while ((len = raf1.read(buff)) != -1) {
                builder.append(new String(buff, 0, len));
            }

            //调回指针，写入"xsx"
            raf1.seek(3);
            raf1.write("xsx".getBytes(StandardCharsets.UTF_8));

            //将StringBuilder中的数据写入到文件中
            raf1.write(builder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}