package com.Syhaun.example;
import com.Syhaun.POJO.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/*
* 品牌数据的增删改查操作
*
*
* */
public class BrandText {
/*
* 查询所有
* 1.SQL: select * from tb_brand;
* 2.参数:不需要
* 3,结果:List<Brand>
* */
    @Test
    public void testSelectAll() throws Exception {
        //获取Connection连接对象
        //        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        获取数据库连接Connecton
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "select * from tb_brand";
        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //设置参数
        //执行sql
        ResultSet resultSet = pstmt.executeQuery();
        //处理结果
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while(resultSet.next())
        {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            brands.add(brand);
        }
        System.out.println(brands);
        //释放资源
        resultSet.close();
        pstmt.close();
        connection.close();
    }
//添加
    @Test
    public void testAdd() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;
        //获取Connection连接对象
        //        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        获取数据库连接Connecton
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status)values(?,?,?,?,?);";
        //获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        //执行sql
        int count = preparedStatement.executeUpdate();
        //处理结果
        System.out.println(count > 0);
        //释放资源
        preparedStatement.close();
        connection.close();
    }

    //修改
    @Test
    public void testUpdata() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球10086圈";
        int status = 1;
        int id = 4;
        //获取Connection连接对象
        //        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        获取数据库连接Connecton
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?";
        //获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);
        //执行sql
        int count = preparedStatement.executeUpdate();
        //处理结果
        System.out.println(count > 0);
        //释放资源
        preparedStatement.close();
        connection.close();
    }
    //删除
    @Test
    public void testDeleteById() throws Exception {
        int id = 4;
        //获取Connection连接对象
        //        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        获取数据库连接Connecton
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "delete from tb_brand where id = ?";
        //获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setInt(1,id);
        //执行sql
        int count = preparedStatement.executeUpdate();
        //处理结果
        System.out.println(count > 0);
        //释放资源
        preparedStatement.close();
        connection.close();
    }
}


