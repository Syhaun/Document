package com.tc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class admin {
    private int id;
    private String stu_num;  //学号
    private String gro;     //小组
    private String name;    //姓名
    private String password;    //密码
}
