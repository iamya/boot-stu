package my.se.demo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {

    public static void main(String[] args) throws IOException {

        FileChannel in = new FileInputStream(new File("F:\\快速入门笔记\\nio介绍.txt")).getChannel();
        FileChannel out = new FileOutputStream(new File("F:\\copynio.txt")).getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.clear();
        while((in.read(buf)) >= 0 || buf.position() != 0) {
            buf.flip();
            out.write(buf);
            buf.compact();
        }
        in.close();
        out.close();
    }
}
