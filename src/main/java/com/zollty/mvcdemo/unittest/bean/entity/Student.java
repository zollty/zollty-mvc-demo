package com.zollty.mvcdemo.unittest.bean.entity;

import java.util.List;

public class Student {
    
    private String name;
    private int age;
    private char sex='S';
    private long time;
    
    private Class clasz;
    
    private List<String> books;
    
    private List<Class> allClasses;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    

    public Class getClasz() {
        return clasz;
    }
    public void setClasz(Class clasz) {
        this.clasz = clasz;
    }
    
   
    public List<String> getBooks() {
        return books;
    }
    public void setBooks(List<String> books) {
        this.books = books;
    }
    
    public List<Class> getAllClasses() {
        return allClasses;
    }
    public void setAllClasses(List<Class> allClasses) {
        this.allClasses = allClasses;
    }
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex + ", time=" + time + ", clasz=" + clasz
                + ", books=" + books + ", allClasses=" + allClasses + "]";
    }
    
}
