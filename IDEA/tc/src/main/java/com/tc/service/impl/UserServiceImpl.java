package com.tc.service.impl;

import com.tc.Mapper.UserMapper;
import com.tc.pojo.User;
import com.tc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //用户登录
    @Override
    public User login(User user) {
        return userMapper.getByStu_numAndPassword(user);
    }

    //用户操作
    @Override
    public void save(User user) {
        if(!isValidPhoneNumber(user.getPhone())) {
            throw new IllegalArgumentException("手机号格式不正确");
        }
        if (isStuNumTaken(user.getStu_num())) {
            throw new IllegalArgumentException("学号已被使用");
        }
        userMapper.insert(user);
    }

    @Override
    public String getInter_condi(String stu_num) {
        return userMapper.getInter_condi(stu_num);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(?:(?:\\+|00)86)?1[3-9]\\d{9}$");
    }
    private boolean isStuNumTaken(String stuNum) {
        User existingUser = userMapper.getByStuNum(stuNum);
        return existingUser != null;
    }
}
