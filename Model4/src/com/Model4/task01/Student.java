package com.Model4.task01;

import java.io.Serializable;
import java.util.Scanner;

/**
 * 其中学生的信息有：学号、姓名、年龄。
 */
public class Student implements Serializable {
    Integer number;

    String name;

    int age;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) throws IdException {
        if (number > 0 && number < 1000000000) {
            this.number = number;
        } else {
            throw new IdException("学号不合理！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            throw new AgeException("年龄不合理！");
        }
    }

    public Student(Integer number, String name, int age) throws IdException, AgeException {
        if (number > 0 && number < 1000000000) {
            this.number = number;
        } else {
            throw new IdException("学号不合理！");
        }
        this.name = name;
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            throw new AgeException("年龄不合理！");
        }
    }

    public Student() throws AgeException, IdException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生的姓名");
        this.setName(sc.nextLine());
        System.out.println("请输入学生的年龄");
        this.setAge(sc.nextInt());
        System.out.println("请输入学生的学号");
        this.setNumber(sc.nextInt());
    }

    public Student(Integer number) throws AgeException, IdException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生的姓名");
        this.setName(sc.nextLine());
        System.out.println("请输入学生的年龄");
        this.setAge(sc.nextInt());
        this.setNumber(sc.nextInt());
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



}
