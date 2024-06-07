package com.model.entity;

public class Teacher {
    private int tid;//教师编号
    private String tname;//姓名
    private Classes classes;//所教班级(student的cid外键)

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "tid=" + tid +
            ", tname='" + tname + '\'' +
            ", classes=" + classes +
            '}';
    }

    public Teacher(int tid, String tname, Classes classes) {
        this.tid = tid;
        this.tname = tname;
        this.classes = classes;
    }

    public int getTid() {

        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}