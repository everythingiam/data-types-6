package HashPrivate;

public class Hash { //хеш-сет ТОЛЬКо на массиве
    private Chelobek[] set;

    public Hash(int number){
        set = new Chelobek[number];
    }
    private int hashFunc(int hash, int i){ //считает хеш-функцию
        return (hash + i) % set.length;
    }

    private int hashCount(Chelobek chel){ //считает сумму интов букв имени
        int result = 0;

        for (int i = 0; i < chel.name.length; i++) {
            result += (int) chel.name[i];
        }
        return result;
    }
    public void INSERT(Chelobek chel){ //вставка в сет
        int count = hashCount(chel);
        int func = hashFunc(count, 0);

        for (int i = 1; i < set.length; i++) {
            if (set[func] == null){
                break;
            }
            if (set[func].compareArrays(chel)){
                return;
            }
            func = hashFunc(count, i);
        }


        set[func] = chel;
    }
    //нужно сделать поиск, котрый вызыывается и в мембере и в делите
    public boolean MEMBER(Chelobek chel){
        int result = find(chel);
        if (result != -1){
            return true;
        }
        return false;
    }
    public void printSet(){
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null || set[i].name[0] == '\0') continue;
            set[i].printChelobek();
        }
    }
    public void DELETE(Chelobek chel){
        int result = find(chel);

        if (result != -1){
            set[result].name[0] = '\0';
        }
    }

    private int find(Chelobek chel){
        int count = hashCount(chel);
        int func = hashFunc(count, 0);
        for (int i = 0; i < set.length; i++) {
            if (set[func] != null && set[func].name[0] == '\0'){
                return -1; //если попали в удалённый
            }

            if (set[func] != null && set[func].compareArrays(chel)){
                return func; //нашли
            }
        }
        return -1; //прошли через весь сет и всё равно не нашли
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