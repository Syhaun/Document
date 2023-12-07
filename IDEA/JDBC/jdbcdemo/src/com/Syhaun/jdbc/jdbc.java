package com.Syhaun.jdbc;
//正常的jdbc修改程序

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String password = "Syhaun20040227.";
        String username = "root";
        String url = "jdbc:mysql://localhost:3306/tlias";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 定义 SQL 语句
        String sql = "UPDATE user\n" +
                "SET phone = 10086\n" +
                "WHERE id = 1;";
        // 获取执行 SQL 的对象 Statement
        Statement stmt = conn.createStatement();
        // 执行 SQL
        int count = stmt.executeUpdate(sql); // 受影响的行数
        // 处理结果
        System.out.println(count);
        // 释放资源
        stmt.close();
        conn.close();
    }
}