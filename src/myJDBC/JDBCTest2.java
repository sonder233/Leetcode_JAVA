package myJDBC;

import java.sql.*;

public class JDBCTest2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动（现在版本的可以省略这一步了
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql_1 = "select * from emp;";
        //获取执行sql对象
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //执行sql
            ResultSet resultSet = stmt.executeQuery(sql_1);
            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+"  ");
                System.out.print(resultSet.getString("name")+"  ");
                System.out.print(resultSet.getString("salary")+"  ");
                System.out.println();
            }

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
