package Mains;
import java.util.Scanner;
import HashPrivate.*;
//import HashPublic.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hash goodguys = new Hash(10);
        Hash badguys = new Hash(10);


        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("E")) {
                System.out.println("Good girls: ");
                goodguys.printSet();
                System.out.println("Bad girls: ");
                badguys.printSet();
                break;
            }

            char command = input.charAt(0);
            String name = input.substring(2).trim();

            Chelobek chel = new Chelobek(name);

            switch (command) {
                case 'F':
                    badguys.DELETE(chel);
                    goodguys.INSERT(chel);
                    break;
                case 'U':
                    goodguys.DELETE(chel);
                    badguys.INSERT(chel);
                    break;
                case '?':
                    if (goodguys.MEMBER(chel)) {
                        System.out.println(name + " is in goodguys");
                    } else if (badguys.MEMBER(chel)) {
                        System.out.println(name + " is in badguys");
                    } else {
                        System.out.println(name + " is not found");
                    }
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        scanner.close();

//        Hash goodgirls = new Hash(10);
//        Hash badgirls = new Hash(10);
//        Chelobek kristina = new Chelobek("kristina");
//        Chelobek alina = new Chelobek("alina");
//        alina.printChelobek();
//        goodguys.INSERT(alina);
//        goodguys.printSet();
//        Chelobek sasha = new Chelobek("sasha");
//        Chelobek assha = new Chelobek("assha");
//        Chelobek sasah = new Chelobek("sasah");
//
//        goodgirls.INSERT(alina);
//        goodgirls.INSERT(sasah);
//        goodgirls.INSERT(sasha);
//        goodgirls.printSet();
//проверять каждый раз, есть ли такое значение. если есть - не вставлять.
//нужно вставлять только в то место, где НИКОГДА ничего не было

//        set.insert();





        // ? alina  ЕНТЕР
        // выведет в каком списке alina (например в плохих)
        /*
        F alina
        ? alina
        alina in good girls
         */

    }
}