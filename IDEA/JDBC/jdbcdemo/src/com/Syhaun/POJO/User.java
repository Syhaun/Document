package com.Syhaun.POJO;

public class User {
    private int id;
    private String name;
    private String stu_num;


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

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stu_num='" + stu_num + '\'' +
                '}';
    }
}
