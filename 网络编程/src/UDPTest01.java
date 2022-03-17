import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author Christp
 * @version 1.0
 * @ClassName UDPTest01
 * @Description TODO
 * @date 2021/10/10 16:29
 */

/*
 * UDP协议的网络编程
 */

public class UDPTest01 {
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "我恁爹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), packet.getLength()));
        socket.close();
    }
}