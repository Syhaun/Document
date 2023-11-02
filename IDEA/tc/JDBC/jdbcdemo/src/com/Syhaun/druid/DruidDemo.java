package com.Syhaun.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import static com.sun.tools.doclint.Entity.prop;

//Druid数据库连接池演示
public class DruidDemo {
    public static void main(String[] args) throws Exception {

//        导入jar包

//        定义配置文件

//        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\代码文件夹集\\IDEA\\tc\\JDBC\\jdbcdemo\\src\\druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        获取数据库连接Connecton
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
