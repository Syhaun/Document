package com.Syhaun.jdbc;


//使用PreparedStatem防止进行sql注入
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc4 {
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
        String  pwd = "123";
        String sql = "select * from user where name = ? and password = ?";
        //获取pstmt对象

        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql

        ResultSet rs = pstmt.executeQuery();


        //判断登录是否成功

        if(rs.next())
            System.out.println("嘿嘿嘿哈");
        else
            System.out.println("哦呦,你干嘛");

       rs.close();
        pstmt.close();
        conn.close();
    }
}