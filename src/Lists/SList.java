package Lists;

import java.util.Arrays;

public class SList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

        public IntNode reverse(){
            if (next == null) {
                return this;
            }
            IntNode reserved = next.reverse();
            next.next = this;
            next = null;
            return reserved;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    //new code below
    public void reverse() {
        IntNode previous = null;
        IntNode now = first;
        IntNode after;

        while(now != null) {
            after = now.next;
            now.next = previous;
            previous = now;
            now = after;
        }

        first = previous;
    }

    public void reverseRecursion(){
        first = first.reverse();
    }

    public void insert(int item, int position) {
        IntNode now = first;
        IntNode previous = null;

        while(position > 1) {
            previous = now;
            now = now.next;
            position--;
        }

        if (previous == null) {
            addFirst(item);
        } else
            {
            previous.next = new IntNode(item, now);
            }
    }

    public void printSlist() {
        printNode(first);
    }

    public void printNode(IntNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.item);
        printNode(node.next);
    }

    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1];
        position = Math.min(position, arr.length);

        for (int i = 0; i < position; i++){
            result[i] = arr[i];
        }
        result[position] = item;
        for (int i = position; i < arr.length; i++) {
            result[i+1] = arr[i];
        }
        return result;
    }

    public static void reverse(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int total = 0;
        for(int i : arr){
            total = total + i;
        }
        int[] result = new int[total];

        int i = 0;
        for(int item : arr) {
            for (int counter = 0; counter < item; counter++){
                result[i] = item;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] test =  new int[]{3,6,9,12};
        System.out.println(Arrays.toString(insert(test, 2, 0)));
        System.out.println(Arrays.toString(insert(test, 10, 3)));
        System.out.println(Arrays.toString(insert(test, 14, 6)));
        System.out.println(Arrays.toString(insert(test, 18, 10)));

        reverse(test);
        System.out.println(Arrays.toString(test));

        int[] test2 = new int[]{3,2,0};
        System.out.println(Arrays.toString(replicate(test2)));

        SList test1 =  new SList();
        test1.addFirst(12);
        test1.addFirst(9);
        test1.addFirst(6);
        test1.addFirst(3);

        test1.insert(8,3);
        test1.insert(2,0);
        test1.printSlist();

        test1.reverse();
        test1.printSlist();

        test1.reverseRecursion();
        test1.printSlist();
    }
}
