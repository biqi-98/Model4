package com.Model4.task01;

import java.util.List;

public class ListAddTest {
    //学生信息添加模块
    public static List<Student> add(List<Student> students) throws AgeException, IdException {
        Student st=new Student();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getNumber().equals(st.getNumber())){
                System.out.println("学生信息输入重复！");
                return students;
            }
        }
        students.add(st);
        System.out.println("学生信息添加成功！");
        return students;

    }
}
