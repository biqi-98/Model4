package com.Model4.task01;

import java.util.List;
import java.util.Scanner;

public class ListUpdateTest {
    //修改学生信息模块
    public static List<Student> update(List<Student> students) throws AgeException, IdException {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入需要修改信息的这位学生的学号:");
        Integer number=sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNumber().equals(number)) {
                Student st = new Student(number);
                students.set(i, st);
                System.out.println("修改成功！");
                return students;
            }
        }
        System.out.println("学生档案库里面没有该学号");
        return students;
    }
}
