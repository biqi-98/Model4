package com.Model4.task04;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {
        Socket s = null;
        Scanner sc = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            // 1.创建Socket类型的对象并提供服务器的主机名和端口号
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");

            // 2.使用输入输出流进行通信
            sc = new Scanner(System.in);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());

//            while (true) {
                // 实现客户端发送的内容由用户从键盘输入

            System.out.println("请输入用户名：");
            String userName = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            User user = new User(userName, password);
            oos.writeObject(user);
            // 接收服务器发来的内容
            Object obj = ois.readObject();
            UserMessage userMessage = (UserMessage) obj;
            if ("success".equalsIgnoreCase(userMessage.getType())) {
                System.out.println("登录成功");
            } else if ("fail".equalsIgnoreCase(userMessage.getType())) {
                System.out.println("登录失败");

            }
//            }

        } catch (IOException | ClassNotFoundException /*| InterruptedException*/ e) {
            e.printStackTrace();
        } finally {
            // 关闭Socket并释放有关的资源
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
