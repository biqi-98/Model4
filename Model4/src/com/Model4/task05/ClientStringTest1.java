package com.Model4.task05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest1 {

    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;

        try {
            // 1.创建Socket类型的对象并提供服务器的主机名和端口号
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");

            // 2.使用输入输出流进行通信
            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ClientSendTest clientSendTest= new ClientSendTest(s);
            clientSendTest.start();
            while(true) {
                if(!clientSendTest.isAlive()){
                    break;
                }
                // 实现接收服务器发来的字符串内容并打印
                String str2 = br.readLine();
                System.out.println("服务器收到的消息是：" + str2);
            }

        } catch (IOException /*| InterruptedException*/ e) {
            e.printStackTrace();
        } finally {
            // 3.关闭Socket并释放有关的资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ps) {
                ps.close();
            }
            if (null != sc) {
                sc.close();
            }
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
