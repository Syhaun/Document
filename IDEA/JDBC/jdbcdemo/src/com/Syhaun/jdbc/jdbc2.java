package com.Syhaun.jdbc;
//用结果集封装查询的结果
import com.Syhaun.POJO.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc2 {
    @Test
   public void testResultSet2() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        String password = "Syhaun20040227.";
        String username = "root";
        String url = "jdbc:mysql://localhost:3306/tlias";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义 SQL 语句
        String sql = "select * from user";
        
        // 获取执行 SQL 的对象 Statement
        Statement stmt = conn.createStatement();
        
        // 执行 SQL
       ResultSet rs = stmt.executeQuery(sql); // 受影响的行数

       //创建一个集合
       List<User> list = new ArrayList<>();

       //光标向下移动一行,并且判断当前行是否有数据
       while(rs.next())
       {
//           获取数据 getXXX()
           User user = new User();
           int id = rs.getInt("id");
           String name = rs.getString("name");
           String stu_num = rs.getString("stu_num");
           //赋值
           user.setId(id);
           user.setName(name);
           user.setStu_num(stu_num);

           //存入集合
           list.add(user);
       }

       System.out.println(list);
        // 释放资源
       rs.close();
        stmt.close();
        conn.close();
    }
}