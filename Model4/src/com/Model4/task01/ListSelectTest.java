package com.Model4.task01;

import java.util.List;
import java.util.Scanner;

public class ListSelectTest {
    //学生查询模块
    public static void check(List<Student> students){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生学号查询学生信息:");
        Integer number=sc.nextInt();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getNumber().equals(number)){
                System.out.println(students.get(i));
                return;
            }
        }
        System.out.println("学生档案库里面没有该学号！");
        return;
    }
}
