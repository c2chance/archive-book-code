package com.model.entity;

public class Student {
  // 学号
  private int id;
  // 姓名
  private String name;
  // 所属班级
  private Classes classes;
  // 性别
  private String sex;
  // 住址
  private String address;

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + ", classes=" + classes + ", sex='"
        + sex + '\'' + ", address='" + address + '\'' + '}';
  }

  public Student() {}

  public Student(int id, String name, Classes classes, String sex, String address) {

    this.id = id;
    this.name = name;
    this.classes = classes;
    this.sex = sex;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Classes getClasses() {
    return classes;
  }

  public void setClasses(Classes classes) {
    this.classes = classes;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
