package my.se.demo;

import java.io.*;

public class IODemo {

    public static void main(String[] args) {

        InputStream in = null;
        OutputStream out = null;

        try {

            in = new FileInputStream( new File( "F:\\快速入门笔记\\nio介绍.txt"));
            out = new FileOutputStream(new File("F:\\copy.txt"));
            byte[] buf = new byte[1024];
            int size;
            while(( size = in.read(buf)) != -1) {
                out.write(buf);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
