package com.ht.test.socket_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(2000);
            System.out.println("服务端已启动，等待连接。。。。");
            Socket socket = server.accept();
            System.out.println("client已成功连接！！！");
            //获取输入liu
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取输出流
            pw = new PrintWriter(socket.getOutputStream(),true);
            String s = br.readLine();//获取接收的数据
            pw.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(br!=null) br.close();
                    if(pw!=null) pw.close();
                    if(server!=null) server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
