package HashPublic;

public class Hash {
    private Chelobek[] set;

    public Hash(int number){
        set = new Chelobek[number/10];
    }
    private int hashCount(Chelobek chel){
        int value = 0;

        for (int i = 0; i < chel.name.length; i++) {
            value += (int) chel.name[i];
        }

        return value % set.length;
    }

    public void INSERT(Chelobek chel){
        int code = hashCount(chel);

        if (set[code] == null){
            set[code] = new Chelobek(chel.toString());
        }
        else {
            Chelobek current = set[code];
            while (current.next != null) { //предыдщуий проверять
                current = current.next;
            }
            current.next = new Chelobek(chel.toString());
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
        }while (current.next != null);
        return false;
    }

//    public int find(Chelobek chel){
//        int count = hashCount(chel);
//    }
    public void printOk(){
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null) continue;

            Chelobek current = set[i];
            while (current != null) {
                current.printChelobek();
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }
    public void DELETE(Chelobek chel) {
        int code = hashCount(chel);
        if (set[code] == null){
            return;
        }
        Chelobek current = set[code];
        do {
            if (current.compareArrays(chel)){
                current.next = current.next.next;
            }
            current = current.next;
        } while (current.next != null);
    }

    public void MAKENULL(){
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
    }

}
