package judge;

import item.Deck;
import item.Player;

public class Judge {

    public boolean pair(Deck deck) {
        if ((deck.getDeck().size() == 2) && (deck.getCardNum(0) == deck.getCardNum(1))){
            System.out.println("It's pair");
            return true;
        }
        return false;
    }

    public boolean boom(Deck deck) {
//        if ((deck.getDeck().size() == 3) && (deck.getCardNum(0) == deck.getCardNum(1) && deck.getCardNum(0) == deck.getCardNum(2))){
//            return 1;
//        } else if ((deck.getDeck().size() == 4)&&(deck.getCardNum(0)==deck.getCardNum(1)&&deck.getCardNum(0)==deck.getCardNum(2)&&deck.getCardNum(0)==deck.getCardNum(3))) {
//            return 1;
//        }else {
//            return 0;
//        }
        for (int i = 1; i < deck.getDeck().size(); i++) {
            if (deck.getCardNum(i) != deck.getCardNum(i - 1)) {
                return false;
            }
        }
        System.out.println("It's boom");
        return true;
    }

    public boolean straight(Deck deck) {
        deck.sort();
        for (int i = 1; i < deck.getDeck().size(); i++) {
            if (deck.getCardNum(i) != deck.getCardNum(i - 1) + 1) {
                return false;
            }
        }
        System.out.println("It's straight");
        return true;
    }

    public boolean paired(Deck deck) {
        deck.sort();
//        if (deck.getDeck().size() >= 3) {
//            for (int i = 1; i < deck.getDeck().size(); i+=2) {
//                if (deck.getCardNum(i) != deck.getCardNum(i - 1) || deck.getCardNum(i) == deck.getCardNum(i + 1)) {
//                    return false;
//                }
//            }
//            return true;
//        }else {
//            return false;
//        }

        int[] checkBoard = new int[14];
//        for (int i:checkBoard
//             ) {
//            i = 0;
//        }
        for (int i = 0; i < deck.getDeck().size(); i++) {
            ++checkBoard[deck.getCardNum(i)];
        }

        for (int value : checkBoard) {
            if (value != 0 && value != 2) {
                return false;
            }
        }
        System.out.println("It's paired");
        return true;
    }

    public void legitimate(Deck deck, Player player) {
//        if (deck.getDeck().size() == 1 || pair(deck) || paired(deck) || boom(deck) || straight(deck)) {
//            System.out.println("出牌符合规则。");
//        } else {
//            System.out.println("出牌不符合规则！");
//            for (int i = 0; i < deck.getDeck().size(); i++) {
//                player.getDeck().add(deck.getDeck().get(i));
//            }
//            deck.getDeck().clear();
//            player.sort();
//        }
        if (deck.getDeck().size() == 1) {
            System.out.println("一张" + deck.getCardNum(0));
        } else if (pair(deck)) {
            System.out.println("对"+ deck.getCardNum(0));
        } else if (paired(deck)) {
            System.out.println("连对");
        } else if (boom(deck)) {
            System.out.println("炸弹");
        } else if (straight(deck)) {
            System.out.println("顺子");
        } else if (deck.getDeck().size() == 0) {
            System.out.println("过");
        } else {
            System.out.println("出牌不符合规则！");
            for (int i = 0; i < deck.getDeck().size(); i++) {
                player.getDeck().add(deck.getDeck().get(i));
            }
            deck.getDeck().clear();
            player.sort();
        }

    }

    public void whichDeck(Deck deck) {

    }
}