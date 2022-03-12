import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Christp
 * @version 1.0
 * @ClassName TCPTest
 * @Description TODO
 * @date 2021/10/10 10:05
 */

/*
* 实现TCP的网络编程
* 例子1：客户端将数据发送给服务端，服务端将数据显示在控制台上
*/

public class TCPTest {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8451);
            os = socket.getOutputStream();
            os.write("我甘霖量".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket so = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的Socket，指明自己的端口号
            ss = new ServerSocket(8451);
            //2.调用accept()表示接受来自于客户端的Socket
            so = ss.accept();
            //3.获取输入流
            InputStream is = so.getInputStream();
//            不建议这么做，有可能会出乱码
//            byte[] buffer = new byte[20];
//            int len;
//            while ((len = is.read(buffer)) != -1){
//                String str = new String(buffer,0, len);
//                System.out.println(str);
//            }

            //读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (so != null){
                try {
                    so.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}