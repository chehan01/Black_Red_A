package server;

import item.Cards;
import dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class Server {
    private Dao dao = new Dao();

    //ȡ��
    public ArrayList<Cards> createDeck() throws SQLException {
        return dao.gerard();
    }
}
