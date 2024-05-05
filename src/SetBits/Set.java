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
        set = new int[(Math.abs(B-A)/32) + 1];
    }


    public void INSERT(int num){
        /*
        1. ищу такое число, которое в битовом предствлении даёт единичку в нужном месте.
        2. Проверяю, если число в принципе входит в диапазон (в методе find_new_num)
        3. считаю, в какую ячейку мне нужно 'вставить' это число. (в методе find_new_num)
        4. делаю пересечение ячейки с найденным числом. Таким образом, я объединю единичку
            на месте нужного нового числа и текущее число.
         */
        int newNum = find_new_num(num);
        if (newNum != -1){
            int index = num / 32;
            set[index] = set[index] | newNum;
        } else System.out.println("ты не в пределах диапазона тупица");
    }

    private int find_new_num(int num){ //делает такое число, где только единица стоит на нужном месте
        if (num > B || num < A){
            return -1;
        }
        return 1 << num;
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
