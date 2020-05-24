package com.Model4.task02;

import java.io.File;
import java.io.IOException;


/**
 * 2. 编程题
 *
 *   实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 */
public class test02 {

    public static void deletes(File file) {

        // 获取目录下的所有内容
        File[] filesArray = file.listFiles();
        // 遍历数组
        for (File tf: filesArray) {
            String name=tf.getName();
            // 若是目录，则需要先删除目录下文件，后删除目录
            if (tf.isDirectory()) {
                deletes(tf);
            }
            tf.delete();
            System.out.println("被删除的文件名为"+name);
        }
    }
    public static void main(String[] args) throws IOException {

        File f1 = new File("F:/要删除的文件夹");
        if (f1.exists()) {
            // 使用递归的思想删除目录以及子目录中的内容
            deletes(new File("F:/要删除的文件夹"));
            f1.delete();
            System.out.println(f1.getAbsolutePath()+"下所有内容均已删除");
        } else {
            System.out.println("文件夹不存在！");
        }
    }

}
