package bag;

import java.util.Iterator;

public class ResizableArrayBag<Item> implements Bag<Item> {

    private Item[] items;
    private int N;

    ResizableArrayBag(){
        items = (Item[]) new Object[10];
        N = 0;
    }
    ResizableArrayBag(int initialCapacity){
        items = (Item[]) new Object[initialCapacity];
        N = 0;
    }

    public void add(Item item) {
        if ( N == items.length )
            resize(2*items.length);

        items[N++] = item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int len) {
        Item[] copy = (Item[]) new Object[len*2];
        for (int i = 0; i < N; i++)
            copy[i] = items[i];
        items = copy;
    }


    // Additional method for provide more convenience

    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() { return i < N; }

        public Item next() { return items[i++]; }
    }
}
