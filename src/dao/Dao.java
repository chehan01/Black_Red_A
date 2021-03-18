package dao;

import item.Cards;
import dbc.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    //ȡ��
    public ArrayList<Cards> gerard() throws SQLException {
        //create a new deck
        ArrayList<Cards> deck = new ArrayList<>();
        //��������
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from cards";
        //Ԥ����sql���
        PreparedStatement ps = conn.prepareStatement(sql);
        //ִ����䲢���ز�ѯ���
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //�����ƶ���
            Cards card = new Cards();
            //��ȡ�Ƶ�����ֵ
            card.setColor(rs.getString(1));
            card.setNumber(rs.getInt(2));
            card.setPower(rs.getInt(3));
            //��������
            deck.add(card);
        }
        //�ر����ݼ����رճ������󣬹ر����ݿ�����
        rs.close();
        ps.close();
        JDBCUtils.close(conn);

        //��������
        return deck;
    }
}
