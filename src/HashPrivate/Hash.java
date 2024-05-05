package HashPrivate;

public class Hash {
    private Chelobek[] set;

    public Hash(int number){
        set = new Chelobek[number];
    }
    private int hashCount(Chelobek chel, int value){
        for (int i = 0; i < chel.name.length; i++) {
            value += (int) chel.name[i];
        }
        return value % set.length;
    }
    //должно быть две функции: хеш функция и хеш значение
    public void INSERT(Chelobek chel){
        if (MEMBER(chel)) return;

        int code = hashCount(chel, 0);

        for (int i = 1; i < set.length; i++) {
            if (set[code] == null){
                break;
            }
            code = hashCount(chel, i);
        }

        set[code] = chel;
    }
    //нужно сделать поиск, котрый вызыывается и в мембере и в делите
    public boolean MEMBER(Chelobek chel){
        int code = hashCount(chel, 0);

        for (int i = 1; i < set.length; i++) {
            if (set[code] != null && chel.compareArrays(set[code])){
                return true;
            }

            code = hashCount(chel, i);
        }

        return false;
    }
    public void printSet(){
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null) System.out.println("NULL");
            else set[i].printChelobek();
        }
    }
    public void DELETE(Chelobek chel){
        int code = hashCount(chel, 0);

        for (int i = 1; i < set.length; i++) {
            if (set[code] != null && chel.compareArrays(set[code])){
                set[code] = new Chelobek(" ");
            }
            code = hashCount(chel, i);
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
4. в конструкторе делить на 10?
 */