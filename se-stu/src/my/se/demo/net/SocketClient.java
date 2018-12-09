package my.se.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        try(Socket socket = new Socket("127.0.0.1", 8761)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("向服务器发送一条消息--->");
            out.println(" Hello, Server ");
            System.out.println(in.readLine());

        }catch (IOException e) {

        }



    }
}
