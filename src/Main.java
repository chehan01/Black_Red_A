import item.Cards;
import item.Deck;
import item.Player;
import judge.Judge;
import server.Server;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {



        //��������
        Deck deck = new Deck();
        //���������ж��ƳصĶ���
        Judge judge = new Judge();
        //�����ж��Ƴ�
        Deck judgeCardsGroup = new Deck();
        //�����ݿ�ȡ��
        deck.setDeck(new Server().createDeck());
        Player A = new Player();
        Player B = new Player();
        Player C = new Player();
        Player D = new Player();
        //�ִΣ�������˭�ȳ���
        int round = 1;
        while (true) {
            //ϴ��
            deck.shuffle();
            //����
            deck.licensing(A, B, C, D);
            //���ֺõ�������
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
            //���γ���
            while (A.getDeck().size() != 0){
                //A�ȳ���
                for (Cards c : A.getDeck()
                ) {
                    System.out.print(c.getNumber() + " ");
                }
                //����������
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
            System.out.println("�Ƿ������Ϸ");
            if(sc.nextInt() == 1){

            }else {
                sc.close();
                break;
            }

        }

    }
}
