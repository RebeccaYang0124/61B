package Lists;

public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return this.rest.size() + 1;
    }

    public int iterativeSize() {
        int result = 1;
        IntList point = this;

        while (point.rest != null ) {
            point = point.rest;
            result ++;
        }

        return result;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return this.rest.get(i - 1);
    }

    public void printIntList(){
        System.out.println(first);
        while (rest != null){
            System.out.println(rest.first);
            rest = rest.rest;
        }
    }

    public static IntList SquareDestructive(IntList L) {
        IntList temp = L;
        while(temp != null) {
            temp.first = temp.first * temp.first;
            temp = temp.rest;
        }
        return L;
    }

    public static IntList SquareDestructiveRe(IntList L) {
        if (L == null){
            return null;
        }
        IntList temp = L;
        temp.first = temp.first * temp.first;
        SquareDestructiveRe(temp.rest);
        return L;
    }

    public static IntList SquareNonDestructive(IntList L) {
        if (L.rest == null){
            return new IntList(L.first * L.first, null);
        }
        return new IntList(L.first * L.first, SquareNonDestructive(L.rest));
    }

    public static IntList SquareNonDestructiveIt(IntList L) {
        if (L == null) {
            return null;
        }
        IntList result = new IntList(L.first * L.first, null);
        IntList temp = result;
        IntList backUp = L;

        while (backUp != null){
            temp.rest = new IntList(backUp.first * backUp.first, null);
            temp = temp.rest;
            backUp = backUp.rest;
        }
        return result;
    }

    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
    }

}
