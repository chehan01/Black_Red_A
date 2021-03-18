package item;

import java.util.ArrayList;

public class Player extends Thread{

    //��ҵ�����
    private ArrayList<Cards> deck = new ArrayList<>();
    //�Ƿ��кں�A
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

    //ץ��
    public void addCard(Cards card) {
        this.deck.add(card);
    }

    //����
    public void sort() {
        this.deck.sort((o1, o2) -> {
            return Integer.compare(o2.getNumber(), o1.getNumber());
        });
    }

    //����
    public void remove(int n,Deck judge) {
        for (Cards c:deck
             ) {
            if (c.getNumber() == n) {
//                ����̨�����Ҫ������
                System.out.print(c.getNumber() +" ");
//                ����ϼҴ��빫���Ƴ��е��ƣ����������ҵ���
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
