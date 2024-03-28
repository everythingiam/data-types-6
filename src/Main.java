import HashPrivate.Chelobek;
import HashPrivate.Hash;

public class Main {
    public static void main(String[] args) {
        Hash set = new Hash(10);
        Chelobek kristina = new Chelobek("kristina");
        Chelobek alina = new Chelobek("alina");
        Chelobek sasha = new Chelobek("sasha");

        set.INSERT(alina);
        set.INSERT(kristina);
        set.DELETE(kristina);
        set.printSet();

        System.out.println();
        System.out.println(set.MEMBER(kristina));
//        set.insert();
    }
}