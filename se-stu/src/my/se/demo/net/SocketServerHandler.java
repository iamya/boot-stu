package my.se.demo.net;

import java.io.*;
import java.net.Socket;

public class SocketServerHandler implements Runnable {

    private Socket socket;

    public SocketServerHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                out.println("服务短接收数据结束, 返回给客户端信息.");
            }
        } catch (IOException e) {

        }

    }
}
