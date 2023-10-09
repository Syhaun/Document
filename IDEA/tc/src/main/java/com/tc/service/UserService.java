package com.tc.service;

import com.tc.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {
  

    //用户登录操作
    User login(User user);



    //用户注册操作
    void save(User user);

    String getInter_condi(String stu_num);
}
