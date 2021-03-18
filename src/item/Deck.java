package item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Deck {
    private ArrayList<Cards> deck = new ArrayList<>();


    public Deck() {
    }

    public ArrayList<Cards> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Cards> deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + getDeck() +
                '}';
    }

    //����
    public void addCards(Cards card) {
        this.getDeck().add(card);
    }

    //ϴ��
    public void shuffle() {
        int n = deck.size();
        Random random = new Random();
        int temp;
        Cards tmpCard;
        for (int i = 0; i < n; i++) {
            temp = random.nextInt(54);
            tmpCard = deck.get(i);
            deck.set(i,deck.get(temp));
            deck.set(temp,tmpCard);
        }
    }
    //����
    public void licensing(Player a,Player b,Player c,Player d) {
        for (int i = 0; i + 3 <= 51; i += 4) {
            a.addCard(deck.get(i));
            b.addCard(deck.get(i + 1));
            c.addCard(deck.get(i + 2));
            d.addCard(deck.get(i + 3));
        }
        a.addCard(deck.get(52));
        b.addCard(deck.get(53));
    }

    //��ȡ�Ŷ���ĳ���Ƶ�ֵ
    public int getCardNum(int n) {
        return this.getDeck().get(n).getNumber();
    }

    //����
    public void sort() {
        this.deck.sort(Comparator.comparingInt(Cards::getNumber));
    }
}
