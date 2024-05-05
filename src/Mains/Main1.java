package Mains;

import SetBits.Set;

public class Main1 {
    public static void main(String[] args){
        Set s = new Set(-10, 99);
        s.INSERT(5);
        s.INSERT(6);
        s.INSERT(36);
        s.INSERT(98);
        s.INSERT(5);
        s.INSERT(36);
//        s.INSERT(-7);
        s.print_set();
    }
}
