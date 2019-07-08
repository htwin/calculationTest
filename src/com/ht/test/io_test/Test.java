package com.ht.test.io_test;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        long start = System.nanoTime();
        InputStream in = null;
        OutputStream out = null;
        try {
             in = new FileInputStream(new File("d:/test/b.txt"));
             out = new FileOutputStream(new File("d:/test/a.txt"),false);
             byte buffer [] = new byte[2048];
             while(in.read(buffer)!=-1){
                 out.write(buffer);
             }
             long end = System.nanoTime();
             System.out.print(end-start+"ns");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(out!=null) out.close();
                    if(in!=null) in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
