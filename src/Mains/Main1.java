package Mains;

import SetBits.Set;

public class Main1 {
    public static void main(String[] args){
        Set s = new Set(-25, 10);
        s.INSERT(6);
//        s.INSERT(-9);
//        s.INSERT(-10);
//        s.INSERT(98);
//        s.INSERT(5);
//        s.INSERT(36);
//        s.INSERT(150);
//        s.INSERT(-7);
        s.print_set();
//        System.out.println((7 << 1) + " " + (-7 << 1));
        int num = 32 % 5;
        System.out.println(Math.pow(2, 31));
    }
}
