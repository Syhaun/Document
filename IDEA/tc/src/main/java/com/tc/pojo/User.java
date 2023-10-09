package com.tc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name; //姓名
    private String stu_num;  //学号
    private String phone;   //电话
    private String major_class; //专业班级
    private String password;    //密码
    private String direct;  //目标方向
    private String inter_cond;  //面试状态
}
