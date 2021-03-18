package item;

import java.util.ArrayList;

public class Player extends Thread{

    //玩家的手牌
    private ArrayList<Cards> deck = new ArrayList<>();
    //是否有黑红A
    private boolean blackOrRed = false;

    public Player() {
    }

    public Player(ArrayList<Cards> deck) {
        this.deck = deck;
    }

    public ArrayList<Cards> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Cards> deck) {
        this.deck = deck;
    }

    //抓牌
    public void addCard(Cards card) {
        this.deck.add(card);
    }

    //排序
    public void sort() {
        this.deck.sort((o1, o2) -> {
            return Integer.compare(o2.getNumber(), o1.getNumber());
        });
    }

    //出牌
    public void remove(int n,Deck judge) {
        for (Cards c:deck
             ) {
            if (c.getNumber() == n) {
//                控制台输出想要出的牌
                System.out.print(c.getNumber() +" ");
//                清除上家存入公共牌池中的牌，并存入该玩家的牌
                judge.getDeck().clear();
                judge.addCards(c);
                deck.remove(c);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "deck=" + deck +
                '}';
    }

    @Override
    public void run() {
        super.run();
    }
}
