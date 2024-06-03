package HashPublic;

public class Hash { //хеш на массиве И СВЯЗНЫХ СПИСУАХ
    private Chelobek[] set;

    public Hash(int number){
        set = new Chelobek[number];
    }
    private int hashCount(Chelobek chel){ //считает хеш сразу
        int value = 0;

        for (int i = 0; i < chel.name.length; i++) {
            value += (int) chel.name[i];
        }

        return value % set.length;
    }
    private Chelobek previous(Chelobek chel, int index){ //находит предыдущий элямент
                                                        // в связном списке, в нужной ячейке массива
        Chelobek prev = null;
        Chelobek current = set[index];

        while (current != null) {
            if (current.compareArrays(chel)){
                return prev;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
    public void INSERT(Chelobek chel){
        int code = hashCount(chel);

        if (set[code] == null){
            set[code] = chel;
        }
        else{
            Chelobek current = set[code];
            Chelobek prev = null;
            while (current != null){
                if (current.compareArrays(chel)) return;
                prev = current;
                current = current.next;
            }

            prev.next = chel;
        }

    }
    public boolean MEMBER(Chelobek chel) {
        int code = hashCount(chel);

        if (set[code] == null) {
            return false;
        }

        Chelobek current = set[code];

        do {
            if (current.compareArrays(chel)) {
                return true;
            }
            current = current.next;
        } while (current != null);
        return false;
    }


    public void printSet(){
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null) continue;

            set[i].printChelobek();

            if (set[i].next != null){
                Chelobek current = set[i];
                while (current.next != null){
                    System.out.print(" --> ");
                    current.next.printChelobek();
                    current = current.next;
                }
            }
            System.out.println();

        }
    }
    public void DELETE(Chelobek chel) {
        int code = hashCount(chel);
        if (set[code] == null){
            return;
        }
        if (set[code].compareArrays(chel)){
            set[code] = set[code].next;
            return;
        }

        Chelobek prev = previous(chel, code);
        if (prev == null){
            return;
        }
        prev.next = prev.next.next;
    }

    public void MAKENULL(){
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
    }


}
