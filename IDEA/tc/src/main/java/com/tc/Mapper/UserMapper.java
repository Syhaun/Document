package com.tc.Mapper;

import com.tc.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //运行时,会自动生成该接口的实现类对象(代理对象),并且将该对象交给IOC容器管理
public interface UserMapper {
    //根据学号和密码查询用户
    @Select("select * from user where stu_num = #{stu_num} and password = #{password}")
    User getByStu_numAndPassword(User user);


    //注册功能
    @Insert("insert into user (stu_num,password,name,phone,major_class,direct)"+
    "values(#{stu_num},#{password},#{name},#{phone},#{major_class},#{direct})")
    void insert(User user);

    //查询学号是否已经使用过了
    @Select("SELECT * FROM user WHERE stu_num = #{stuNum}")
    User getByStuNum(String stuNum);


    //查询面试状态信息
    @Select("SELECT inter_cond FROM user WHERE stu_num = #{stu_num}")
    String getInter_condi(String stu_num);
}
