package Lists;

public class SLList {
    private IntNode first;
    private IntNode sentinal;
    private int size;

    //static class : never lookout of the class
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList() {
        size = 0;
        sentinal = new IntNode(0, null);
    }

    public SLList(int x) {
        size = 1;
        sentinal = new IntNode(0, null);
        sentinal.next = new IntNode(x, null);
    }

    public void addFirst(int x ) {
        sentinal.next = new IntNode(x, sentinal.next);
        size += 1;
    }

    public int getFirst() {
        return sentinal.next.item;
    }

    public void addLast(int x) {
        size += 1;

        IntNode p = sentinal;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    private static int size(IntNode p) {
        while (p.next != null) {
            return size(p.next) + 1;
        }
        return 1;
    }


    public int size() {
        return size(first);
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);

        System.out.println(L.size());

        int[] x = new int[]{1,2,3};
    }
}
