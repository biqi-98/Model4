package com.Model4.task01;

import java.util.List;
import java.util.Scanner;

public class ListDeleteTest {
    //删除学生信息模块
    public static List<Student> delete(List<Student> students){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生学号删除学生信息:");
        Integer number=sc.nextInt();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getNumber().equals(number)){
                students.remove(i);
                System.out.println("学生信息删除成功！");
                return students;
            }
        }
        System.out.println("学生档案库里面没有该学号!");
        return students;
    }
}
