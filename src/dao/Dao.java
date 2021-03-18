package dao;

import item.Cards;
import dbc.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    //取牌
    public ArrayList<Cards> gerard() throws SQLException {
        //create a new deck
        ArrayList<Cards> deck = new ArrayList<>();
        //创建连接
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from cards";
        //预编译sql语句
        PreparedStatement ps = conn.prepareStatement(sql);
        //执行语句并返回查询结果
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //创建牌对象
            Cards card = new Cards();
            //获取牌的属性值
            card.setColor(rs.getString(1));
            card.setNumber(rs.getInt(2));
            card.setPower(rs.getInt(3));
            //存入牌组
            deck.add(card);
        }
        //关闭数据集，关闭陈述对象，关闭数据库连接
        rs.close();
        ps.close();
        JDBCUtils.close(conn);

        //返回牌组
        return deck;
    }
}
