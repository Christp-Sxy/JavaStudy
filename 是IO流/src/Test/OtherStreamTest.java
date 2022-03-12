package Test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Christp
 * @version 1.0
 * @ClassName OtherStreamTest
 * @Description TODO
 * @date 2021/10/5 20:49
 */

/*
* 1.标准的输入输出流
* 1.1
*   System.in:标准的输入流，默认从键盘输入
*   System.out:标准的输出流，默认从控制台输出
* 1.2
*   System类的setIn() / setOut()方式重新指定输入和输出的流
*
* 2.打印流：
*   PrintStream和PrintWriter
* 2.1
*   提供了一系列重载的print() 和 println()
*
* 3.数据流
* 3.1
*   DataInputStream和DataOutputStream
* 3.2
*   作用：用于读取或写出基本数据类型的变量或字符串
* 3.3
*   注意点：读取不同文件的数据的顺序要与当初写入时保存的顺序一致
*
*/

public class OtherStreamTest {

    @Test
    public void test01(){
        //将输入的字符串转成大写，遇到 e 或 exit 结束程序

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符串:");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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