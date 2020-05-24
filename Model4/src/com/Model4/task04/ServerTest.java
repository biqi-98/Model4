package com.Model4.task04;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 4. 编程题
 *
 *   使用基于 tcp 协议的编程模型实现将 UserMessage 类型对象由客户端发送给服务器；
 *
 *   服 务 器接 收到 对象 后判 断 用户 对象 信息 是否 为 "admin" 和 "123456"， 若 是则 将 UserMessage 对象中的类型改为"success"，否则将类型改为"fail"并回发给客户端，客户 端接收到服务器发来的对象后判断并给出登录成功或者失败的提示。
 *
 *   其中 UserMessage 类的特征有：类型(字符串类型) 和 用户对象(User 类型)。
 *
 *   其中 User 类的特征有：用户名、密码(字符串类型)。
 *
 *   如：
 *
 *                 UserMessage tum = new UserMessage("check", new User("admin", "123456"));
 */
public class ServerTest {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            //创建ServerSocket类型的对象并提供端口号
            ss = new ServerSocket(8888);

            // 等待客户端的连接请求
            System.out.println("等待客户端的连接请求...");
            s = ss.accept();
            System.out.println("客户端连接成功！");

            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
//            while (true) {
                // 实现对客户端发来字符串内容的接收
            User user = (User) ois.readObject();
            UserMessage userMessage = new UserMessage(user, "fail");
            if ("admin".equalsIgnoreCase(user.getUserName()) && "123456".equalsIgnoreCase(user.getPassword())) {
                userMessage.setType("success");
            }
            oos.writeObject(userMessage);
            System.out.println("服务器发送数据成功！");
//            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
