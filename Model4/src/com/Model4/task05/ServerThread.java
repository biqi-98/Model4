package com.Model4.task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 5. 编程题
 *
 *   使用基于 tcp 协议的编程模型实现多人同时在线聊天和传输文件，要求每个客户端将发 送的聊天内容和文件发送到服务器，服务器接收到后转发给当前所有在线的客户端。
 */
public class ServerThread extends Thread {
    private Socket s;
    public static List<Socket> sockets=new ArrayList<>();

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;

        try {
            // 3.使用输入输出流进行通信
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));


            while(true) {
                // 实现对客户端发来字符串内容的接收并打印
                String s1 = br.readLine();
                InetAddress inetAddress = s.getInetAddress();
                System.out.println("客户端" + inetAddress + "发来的字符串内容是：" + s1);

                // 实现服务器向客户端回发字符串内容"I received!"
                for(Socket socket:sockets) {
                    ps = new PrintStream(socket.getOutputStream());
//                    ps.println("I received!");
                    ps.println(s1);
                    System.out.println("服务器发送数据成功！");
                }
                // 当客户端发来的内容为"bye"时，则聊天结束
                if ("bye".equalsIgnoreCase(s1)) {
                    System.out.println("客户端" + inetAddress + "已下线！");
                    //在一台电脑上启动，可能会移除错误的客户端，暂时未找到解决办法
                    sockets.remove(sockets.indexOf(this.s));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ps) {
                ps.close();
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
