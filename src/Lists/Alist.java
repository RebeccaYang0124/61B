package Lists;

import java.util.Arrays;

public class Alist<Item> {
    private Item[] item;
    private int size;

    public Alist() {
        item = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] newItem = (Item[]) new Object[capacity];
        System.arraycopy(item, 0, newItem, 0, size);
        item = newItem;

    }

    public void addLast(Item x) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[size] = x;
        size += 1;
    }

    public Item getLast() {
        return item[size - 1];
    }

    public Item get(int x){
        return item[x];
    }

    public int size(){
        return size;
    }

    public Item removeLast(){
        Item result = getLast();
        item[size - 1] = null;
        size -= size;
        return result;
    }
}
