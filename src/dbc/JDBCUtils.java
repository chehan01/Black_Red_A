package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils  {
    //创建数据库连接
    public static Connection getConnection() {
        final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
        final String DBURL = "jdbc:mysql://localhost:3306/card?characterEncoding=GBK&serverTimezone=UTC";
        final String DBUSER = "root";
        final String DBPASS = "917350";
        Connection conn=null;
        try
        {
            Class.forName(DBDRIVER);
            conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void close(Connection conn) {
        if(conn!=null)
        {
            try
            {
                conn.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
            conn = null;
        }else {
            System.out.println("数据库关闭失败！");
        }
    }
}
