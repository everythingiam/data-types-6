package SetBits;

public class Set {
    int[] set;
    int A, B;
    public Set(int A, int B){
        /*
        1. Считаю разницу В и А (абсолютным значением) и заношу их в поля.
        2. Делю результат на 32, чтобы понять, сколько памяти выделить для массива.
         */

        this.A = A;
        this.B = B;

        set = new int[differense(A, B) + 1];

        //короче добавиьт проверку если диапазон от -5 до 10 например
        //потому что пр делении на отрицаиельное число округляется в меньшую сторону, (-1).

    //иметь 0 в одном
    }

    private class Position{
        int arrayIndex;
        int bitIndex;

        private Position(int index, int pos){
            arrayIndex = index;
            bitIndex = pos;
        }
    }

    private int differense(int a, int b){
        return (b >> 5) - (a >> 5);
    }

    //создать отдельный класс дл япозиции с полями: 1. индекс массива, 2. номер бита.
    //созлать метод файнд позишен, котоырй возвращает объект класса позиции

    public void INSERT(int num){
        /*
        1. ищу такое число, которое в битовом предствлении даёт единичку в нужном месте.
        2. Проверяю, если число в принципе входит в диапазон (в методе find_new_num)
        3. считаю, в какую ячейку мне нужно 'вставить' это число. (в методе find_new_num)
        4. делаю пересечение ячейки с найденным числом. Таким образом, я объединю единичку
            на месте нужного нового числа и текущее число.
         */
        if (num < 0){

        }

        /*
        1. проверка на пределы
        2. получить позицию числа в массике
        3. с помощью логического ИЛИ заменяем бит на 1
         */
        int newNum = find_1_num(num);
        if (newNum != -1){
            int index = (differense(A, B) - num) / 32;
            set[index] = set[index] | newNum;
        } else System.out.println("ты не в пределах диапазона тупица");
    }

    //создать метод копирования и использовать его

    private int find_1_num(int num){ //делает такое число, где только единица стоит на нужном месте
        if (num > B || num < A){
            return -1;
        }
        if (num < 0){
//          return (num + 32) % 32;
            return (1 << Math.abs(num)) | (-(int) Math.pow(2, 3));
        }
        return (num - A) % 32;
//        return num % 32;
        //остаток от деления % на 32 сразу ищет на каком месте находится БИТ. (только в положиьельныйх)
        //если често >0 ничего не добавлять, если нет, то добавить 32.
    }

    private String bit_to_set(int num, int i){
        String string = "";
        int cursor = 1;
        for (int j = 0; j < 32; j++) {
            if ((cursor & num) != 0) {
                string = string + (j + (i*32)) + ", ";
            }

            cursor = cursor << 1;
        }
        return string;
    }
    public void print_set(){
        String string = "{ ";
        for (int i = 0; i < set.length; i++) {
            string += bit_to_set(set[i], i);
        }
        string+="}";
        System.out.println(string);
    }
}

/*
package SetBits;

public class Set {
    int[] set;
    int A, B;
    int size;

    public Set(int A, int B) {
        this.A = A;
        this.B = B;
        this.size = B - A + 1;
        this.set = new int[(size + 31) / 32]; // Определяем размер массива, чтобы вместить все числа
    }

    private int getArrayIndex(int num) {
        return (num - A) / 32;
    }

    private int getBitIndex(int num) {
        return (num - A) % 32;
    }

    public void INSERT(int num) {
        if (num < A || num > B) {
            System.out.println("Число не в пределах диапазона: " + num);
            return;
        }

        int arrayIndex = getArrayIndex(num);
        int bitIndex = getBitIndex(num);

        set[arrayIndex] |= (1 << bitIndex);
    }

    private String bit_to_set(int num, int offset) {
        StringBuilder string = new StringBuilder();
        for (int j = 0; j < 32; j++) {
            if ((num & (1 << j)) != 0) {
                string.append(offset + j).append(", ");
            }
        }
        return string.toString();
    }

    public void print_set() {
        StringBuilder string = new StringBuilder("{ ");
        for (int i = 0; i < set.length; i++) {
            string.append(bit_to_set(set[i], A + i * 32));
        }
        string.append("}");
        System.out.println(string.toString());
    }

    public static void main(String[] args) {
        Set s = new Set(-25, 10);
        s.INSERT(5);
        s.INSERT(-9);
        s.print_set();
    }
}

 */