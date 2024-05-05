package HashPublic;

public class Chelobek {
    char[]  name;
    Chelobek next;
    public Chelobek(String nameS){
        char[] nameC = nameS.toCharArray();
        name = new char[nameC.length];
        for (int i = 0; i < nameC.length; i++) {
            name[i] = nameC[i];
        }
        next = null;
    }

    public void printChelobek(){
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);
        }
//        System.out.println();
    }

    public boolean compareArrays(Chelobek a){
        if (a.name.length != this.name.length) return false;
        for (int i = 0; i < a.name.length; i++) {
            if (a.name[i] != this.name[i]){
                return false;
            }
        }
        return true;
    }
}
