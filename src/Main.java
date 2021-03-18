import item.Cards;
import item.Deck;
import item.Player;
import judge.Judge;
import server.Server;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {



        //创建牌组
        Deck deck = new Deck();
        //创建用来判定牌池的对象
        Judge judge = new Judge();
        //创建判定牌池
        Deck judgeCardsGroup = new Deck();
        //从数据库取牌
        deck.setDeck(new Server().createDeck());
        Player A = new Player();
        Player B = new Player();
        Player C = new Player();
        Player D = new Player();
        //局次，决定由谁先出牌
        int round = 1;
        while (true) {
            //洗牌
            deck.shuffle();
            //分牌
            deck.licensing(A, B, C, D);
            //给分好的牌排序
            A.sort();
            B.sort();
            C.sort();
            D.sort();
//            System.out.println(deck.toString());
//            System.out.println();
//
//            System.out.println(A.toString());
//            System.out.println();
//
//            System.out.println(B.toString());
//            System.out.println();
//
//            System.out.println(C.toString());
//            System.out.println();
//
//            System.out.println(D.toString());
            //依次出牌
            while (A.getDeck().size() != 0){
                //A先出牌
                for (Cards c : A.getDeck()
                ) {
                    System.out.print(c.getNumber() + " ");
                }
                //创建输入流
                Scanner sc = new Scanner(System.in);
                while (!sc.hasNext("#")) {
                    A.remove(sc.nextInt(),judgeCardsGroup);
                }
                judge.legitimate(judgeCardsGroup,A);
                System.out.println();
                System.out.println(judgeCardsGroup.toString());
                System.out.println();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("是否继续游戏");
            if(sc.nextInt() == 1){

            }else {
                sc.close();
                break;
            }

        }

    }
}
