package HashPrivate;

public class Hash {
    private Chelobek[] set;

    public Hash(int number){
        set = new Chelobek[number];
    }
    private int hashCount(Chelobek chel, int value){
//        int hash = 0;
        for (int i = 0; i < chel.name.length; i++) {
            value += (int) chel.name[i];
        }
        return value % chel.name.length;
        /*
        1. в цикле поэлементно складываю их хеш коды (там функция (int))
         */
    }
    private char[] copyArray(char[] array){
        char[] copy = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public void INSERT(Chelobek chel){
        int hash = hashCount(chel, 0);
        int i = 0;

        while (set[hash] != null){
            i++;
            hash = hashCount(chel, i);
        }

        set[hash] = chel;
    }
    public boolean MEMBER(Chelobek chel){
        for (int i = 0; i < set.length; i++) {
            if (set[hashCount(chel, i)] != null && chel.compareArrays(set[hashCount(chel, i)])){
                return true;
            }
        }
        return false;
    }
    public void printSet(){
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null) System.out.println("null");
            else set[i].printChelobek();
        }
    }
    private int searchHashCount(int code){ //возможно нужно создать
        for (int i = 0; i < set.length; i++) {
//            if ()
        }
        return 0;
    }
    public void DELETE(Chelobek chel){
        for (int i = 0; i < set.length; i++) {
            int code = hashCount(chel, i);
            if (set[code] != null && chel.compareArrays(set[code])){
                set[code] = null;
            }
        }
    }
    public void MAKENULL(){
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
    }
}
/*
Вопросы:
1. Допустим я задаю хешсет, размером 10. Могу ли я туда пихать больше, чем 10 человек?
2. Если да, то что происходит при открытом хешировании, когда происходит коллизия?
3. чё за Е?
 */