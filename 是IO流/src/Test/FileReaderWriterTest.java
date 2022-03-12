package Test;

import org.junit.Test;

import java.io.*;

/**
 * @author Christp
 * @version 1.0
 * @ClassName FileReaderWriterTest
 * @Description TODO
 * @date 2021/10/3 16:30
 */

/*
* 一、流的分类：
* 1.操作数据单位：字节流、字符流
* 2.数据的流向：输入流、输出流
* 3.流的角色：节点流、处理流
*
* 二、流的体系结构：
* 抽象基类：                                     节点流：                                                 缓冲流：(处理流的一种)
*   InputStream                 FileInputStream     (read(byte[] buffer)                    BufferedInputStream (read(byte[] buffer
*   OutputStream                FileOutputStream    (write(byte[] buffer, 0, len))           BufferedOutputStream (write(byte[] buffer, 0, len) / flush())
*   Reader                      FileReader          (read(char[] buffer)                    BufferedReader (read(char[] buffer / readline())
*   Writer                      FileWriter          (write(char[] buffer, 0, len))           BufferedWriter (write(char[] buffer, 0, len) / flush())
*/

public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相对路径为当前工程
        System.out.println("ss");
    }

    /*
     * 将 是IO流 文件夹下的hello.txt读入程序，并输出到控制台中
     *   异常的处理：为了保证资源一定可以执行关闭操作，需要使用try-catch-finally
     *   读入的文件一定要存在，否则就会报FileNotFoundException
     */

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类型的对象，指明要操作的文件
            File file = new File("hello.txt");//相对路径为当前module

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read()返回读取的一个字符，如果到达文件末尾，返回-1
//        方式一：
//        int data = fr.read();
//        while (data != -1){
//            System.out.println((char)data);
//            data = fr.read();
//        }

//        方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            //4.流的关闭操作
//            try {
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()方法的操作升级：使用read()的重载方法
    @Test
    public void FileReaderTest01() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {

                //方式一
//                错误的写法
//                for (int i = 0; i < cbuffer.length; i++) {
//                    System.out.println(cbuffer[i]);
//                }

//              正确的写法
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuffer[i]);
                }

                //方式二
//                错误的写法
//                String str = new String(cbuffer);
//                System.out.println(str);
                //正确的写法
                String str = new String(cbuffer);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
     * 从内存中写出数据到硬盘文件
     *
     * 说明：
     * 1.输出操作，对应的File可以不存在，不会报异常
     * 2.File对应的硬盘中的文件如果不存在，在输出过程中，会自动创建此文件
     *   File对应的硬盘中的文件如果存在:
     *       如果流使用的构造器是FileWriter(file, false)/FileWriter(file):则是对原有的文件进行覆盖
     *       如果流使用的构造器是FileWriter(file, true):不会对原有文件进行覆盖，而是在原有文件基础上进行追加操作
     */

    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);

            //3.写出的操作
            fw.write("你寄吧谁啊\n");
            fw.write("咋，不服啊");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流资源的关闭
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReaderFileWriter() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            //1.提供File类的对象，指明写出到的文件\
            File srcfile = new File("hello.txt");
            File destfile = new File("hello2.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);

            //3.数据的读入和写出的操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf中数据的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
