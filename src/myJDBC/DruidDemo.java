package myJDBC;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 定义配置文件 druid.properties
        // 加载配置
        Properties prop = new Properties();
        prop.load(new FileReader("E:\\JavaProject\\Leetcode_java\\src\\myJDBC\\druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 获取数据库连接connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
