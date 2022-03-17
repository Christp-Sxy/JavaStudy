package Test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Christp
 * @version 1.0
 * @ClassName FileInputOutputTest
 * @Description TODO
 * @date 2021/10/4 20:14
 */

/*
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论:
 * 1.对于文本文件(.txt, .java, .c, .cpp...)，使用字符流处理
 * 2.对于非文本文件(.jpg, .mp3, .mp4, .avi...)，使用字节流处理
 */

public class FileInputOutputTest {

    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.写出的操作
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流资源的关闭
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 实现对图片的复制操作
     */

    @Test
    public void testFileInputOutputStream() {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //1.提供File类的对象，指明写出到的文件\
            File srcfile = new File("jojo.jpg");
            File destfile = new File("jojo1.jpg");

            //2.创建输入流和输出流的对象
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //3.数据的读入和写出的操作
            byte[] cbuf = new byte[5];
            int len;//记录每次读入到cbuf中数据的个数
            while ((len = fis.read(cbuf)) != -1) {
                //每次写出len个字符
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //1.提供File类的对象，指明写出到的文件\
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            //2.创建输入流和输出流的对象
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //3.数据的读入和写出的操作
            byte[] cbuf = new byte[5];
            int len;//记录每次读入到cbuf中数据的个数
            while ((len = fis.read(cbuf)) != -1) {
                //每次写出len个字符
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}