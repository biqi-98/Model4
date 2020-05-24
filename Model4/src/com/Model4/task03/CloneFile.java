package com.Model4.task03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CloneFile implements Runnable {
    String name;
    String fileName1;
    String fileName2;

    public CloneFile() {
    }

    public CloneFile(String name,String fileName1, String fileName2) {
        this.name = name;
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
    }

    @Override
    public void run() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 读文件
            fis = new FileInputStream(fileName1);
            System.out.println("正在拷贝:"+name);
//            Thread.sleep(10000);
            // 写文件
            fos = new FileOutputStream(fileName2);
            // 准备一个相对适当的缓冲区，分多次将文件拷贝完成
            byte[] bArr = new byte[1024];
            int res = 0;
            while ((res = fis.read(bArr)) != -1) {
                fos.write(bArr, 0, res);
            }
            System.out.println("拷贝文件"+name+"成功！");
        } catch (IOException /*| InterruptedException*/ e) {
            e.printStackTrace();
        } finally {
            // 关闭流对象
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
