package my.se.demo.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SocketServer {

    private static final  int PORT = 8761;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            Socket socket = serverSocket.accept();

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new SocketServerHandler(socket));


        } catch (IOException e) {

        }
    }
}
