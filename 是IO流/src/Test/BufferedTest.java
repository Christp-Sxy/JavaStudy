package Test;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author Christp
 * @version 1.0
 * @ClassName BufferedTest
 * @Description TODO
 * @date 2021/10/4 20:51
 */

/*
* 处理流之一：缓冲流的使用
* 1.缓冲流：
*   BufferedInputStream
*   BufferedOutputStream
*   BufferedReader
*   BufferedWriter
*
* 2.作用：提高数据的读取和写入效率
*
* 3.提高读写速度的原因：内部提供了一个缓冲区
*
* 4.处理流就是“套接”造已有的流的基础上的
*
*/

public class BufferedTest {

    /*
    * 实现非文本文件的复制
    */

    @Test
    public void testBufferedStream(){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.提供File类的对象，指明写出到的文件\
            File srcfile = new File("jojo.jpg");
            File destfile = new File("jojo1.jpg");

            //2.1先造节点流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //2.2再造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.数据的读入和写出的操作
            byte[] cbuf = new byte[5];
            int len;//记录每次读入到cbuf中数据的个数
            while ((len = bis.read(cbuf)) != -1) {
                //每次写出len个字符
                bos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层流，在关闭内层流
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //说明：关闭外层流的同时，内层流也会自动关闭，关于内层流的关闭，我们可以省略

            /*
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            */
        }
    }

    //实现文件的复制的方法
    public void copyFileWithBuffer(String srcPath, String destPath){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.提供File类的对象，指明写出到的文件\
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            //2.1先造节点流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //2.2再造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.数据的读入和写出的操作
            byte[] cbuf = new byte[5];
            int len;//记录每次读入到cbuf中数据的个数
            while ((len = bis.read(cbuf)) != -1) {
                //每次写出len个字符
                bos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层流，在关闭内层流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 使用BufferedReader和BufferedWriter实现文本文件的复制
    */

    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("C:\\Users\\sxy\\Documents\\霓虹深渊作弊码.txt")));
            bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\sxy\\Documents\\霓虹深渊作弊码01.txt")));

            //读写操作
            //方式一：使用char[]数组
            /*
            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                //每次写出len个字符
                bw.write(cbuf, 0, len);
            }*/

            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                //方法一
//                bw.write(data);//data中是包含换行符的
                //方法二
                bw.write(data);
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}