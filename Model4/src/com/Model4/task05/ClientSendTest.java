package com.Model4.task05;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ClientSendTest extends Thread {
    private Socket s;

    public ClientSendTest(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
            Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入要发送的字符内容或文件路径：");
            String str1 = sc.next();
            // 判断文件存在
            File file = new File(str1);
            if(file.exists()){
                try {
                    ps.println(Arrays.toString(new FileInputStream(file).readAllBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端发送文件！");

            }else{
                ps.println(str1);
            }
            System.out.println("客户端发送数据内容成功！");
            // 当发送的数据内容为"bye"时，则聊天结束
            if ("bye".equalsIgnoreCase(str1)) {
                System.out.println("聊天结束！");
                break;
            }
        }
        return;
    }
}
