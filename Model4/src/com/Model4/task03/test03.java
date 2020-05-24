package com.Model4.task03;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3. 编程题
 *
 *   使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class test03 {


    public static void clones(File file,File file1) {
        // 获取目录下的所有内容
        File[] filesArray = file.listFiles();
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 遍历数组
        for (File tf: filesArray) {
            String name=tf.getName();
            // 若是目录，则需要先复制目录，后复制目录下文件
            if (tf.isDirectory()) {
                System.out.println("创建文件夹:[" + name + "]");
                File cloneFile = new File(tf.getAbsolutePath().replace(file.getAbsolutePath(),file1.getAbsolutePath()));
                cloneFile.mkdir();
                clones(tf,cloneFile);
            }else {
                CloneFile cloneFile=new CloneFile(name,tf.getAbsolutePath(),tf.getAbsolutePath().replace(file.getAbsolutePath(),file1.getAbsolutePath()));
                //向线程池中加入
                executorService.execute(cloneFile);
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {

        File f1 = new File("F:/要复制的文件夹");
        File f2 = new File("F:/被复制的文件夹");
        if (f1.exists()) {
            if (!f2.exists()) {
                f2.mkdir();
            }
            // 使用递归的思想复制目录以及子目录中的内容
            clones(f1,f2);
        } else {
            System.out.println("文件夹不存在！");
        }
    }
}
