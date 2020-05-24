package com.Model4.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 编程题
 *
 *   基于学生信息管理系统增加以下两个功能：
 *
 *             a.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
 *
 *             b.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
 */
public class test01 {

    private static List<Student> students=new ArrayList<>();

    public static void run(){
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("请按照提示输入数字查询你所需要的功能:");
            System.out.println("1,查看所有学生信息。2,根据学号查找某个学生的信息。3,根据学号删除某个学生的信息。");
            System.out.println("4,添加一个学生信息。5,根据学号修改某个学生的信息。6,退出。");
            switch(sc.nextInt()){
                case 1:
                    System.out.println(students.toString());
                    break;
                case 2:
                    ListSelectTest.check(students);
                    break;
                case 3:
                    ListDeleteTest.delete(students);
                    break;
                case 4:
                    try {
                        ListAddTest.add(students);
                    } catch (AgeException | IdException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        ListUpdateTest.update(students);
                    } catch (AgeException | IdException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("请按照提示输入！");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        File f1 = new File("d:/student.txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        // 若文件存在则获取文件,读取文件中所有学生信息到集合中
        if (f1.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream("d:/student.txt"));
                Object obj = ois.readObject();
                students= (List<Student>) obj;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (null != ois) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        run();
        //当系统退出时将 List 集合中所有学生信息写入到文件中
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
            oos.writeObject(students);
            System.out.println("写入对象成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
