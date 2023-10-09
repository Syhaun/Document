package com.tc.contorller;

import com.tc.pojo.Result;
import com.tc.pojo.User;
import com.tc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //根据学号和密码用户进行登录
        log.info("用户登录:{}",user);
        User e = userService.login(user);
        return e != null ? Result.success():Result.error("用户名或密码错误");

    }

    @PostMapping("/register")
    public Result save(@RequestBody User user) {
        //注册新用户,录入用户的学号,密码,姓名,专业班级,手机号,目标方向信息.
       try{ userService.save(user);
        return Result.success();}catch(Exception ex) {
           return Result.error("注册失败: "+ ex.getMessage());
       }
    }
    @PostMapping("/select")
    public Result getInter_Condi(@RequestBody User user) {
        //查询面试状态信息
        String interCond = userService.getInter_condi(user.getStu_num());
            Result result = Result.success(interCond);
            return result;
    }

}
