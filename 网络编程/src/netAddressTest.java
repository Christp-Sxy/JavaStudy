import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Christp
 * @version 1.0
 * @ClassName netAdressTest
 * @Description TODO
 * @date 2021/10/7 20:21
 */

/*
 * 一、网络编程中有两个主要问题
 * 1.如何准确地定位网络上的一台或多台主机：定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层，网络层、物理+数据链路层)
 *
 * 三、通信要素一：IP和端口号
 * 1.IP：唯一的标识Internet上的计算机(通信实体)
 * 2.在Java中使用InetAddress代表IP
 * 3，IPV4和IPV6；万维网和局域网
 * 4.域名：不做过多解释
 * 5.本地回路地址：127.0.0.1 对应localhost
 * 6.如何实例化InetAddress:两个方法：getByName(String host) , getLocalHost()(获取本机地址)
 *   两个常用方法：getHostName() / getHostAddress()
 * 7.端口号：表示计算机上正在运行的进程
 *   要求：不同进程有不同的端口号
 *   范围：被规定为一个16位的整数0 ~ 65535
 * 8.IP地址与端口号的组合得出一个网络套接字：Socket
 */

public class netAddressTest {
    public static void main(String[] args) {
        InetAddress inet1 = null;
        try {
            inet1 = InetAddress.getByName("127.127.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet1);

        InetAddress inet2 = null;
        try {
            inet2 = InetAddress.getByName("www.christp.work");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet2);
    }
}