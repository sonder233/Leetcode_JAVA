package myJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动（现在版本的可以省略这一步了
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql_1 = "update emp set salary = 2500 where id = 1;";
        String sql_2 = "update emp set salary = 3000 where id = 2;";
        //获取执行sql对象
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //执行sql
            int count_1 = stmt.executeUpdate(sql_1);
            System.out.println(count_1);

            int count_2 = stmt.executeUpdate(sql_2);
            System.out.println(count_2);

            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }
        stmt.close();
        conn.close();
    }
}
