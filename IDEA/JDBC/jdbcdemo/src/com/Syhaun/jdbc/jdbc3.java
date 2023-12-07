package com.Syhaun.jdbc;

//sql注入的演示
import com.Syhaun.POJO.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbc3 {
    @Test
   public void testResultSet2() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        String password = "Syhaun20040227.";
        String username = "root";
        String url = "jdbc:mysql://localhost:3306/tlias";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接受用户输入用户名和密码
        String name = "熊大";
        String  pwd = "'or'1'='1";
        String sql = "select * from user where name = '"+name+"' and password = '"+pwd+"'";
        //获取stmt对象

        Statement stmt = conn.createStatement();

        //执行sql

        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功

        if(rs.next())
            System.out.println("嘿嘿嘿哈");
        else
            System.out.println("哦呦,你干嘛");

       rs.close();
        stmt.close();
        conn.close();
    }
}