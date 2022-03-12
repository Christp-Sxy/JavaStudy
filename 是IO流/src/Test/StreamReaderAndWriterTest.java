package Test;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Christp
 * @version 1.0
 * @ClassName StreamReaderAndWriterTest
 * @Description TODO
 * @date 2021/10/5 19:19
 */

/*
* 处理流之二：转换流的使用
* 1.转换流：
*   InputStreamReader：将一个字节的输入流转换为字符的输出流
*   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
* 2.提供字符流和字节流的转换
* 3.解码：字节，字节数组 ——> 字符串，字符数组
*   编码：字符串，字符数组 ——> 字节，字节数组
* 4.字符集
 *
*/

public class StreamReaderAndWriterTest {

    @Test
    public void test01(){
        FileInputStream fis = null;
        try {
            File file;
            fis = new FileInputStream("hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符解码
            //参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);//

            byte[] cbuf = new byte[20];
            int len;
            while ((len = fis.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 综合使用InputReader和OutputWriter
    */

    @Test
    public void test02(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            osw = new OutputStreamWriter(fos, "GBK");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}