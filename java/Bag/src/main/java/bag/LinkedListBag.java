package bag;

import java.util.Iterator;

public class LinkedListBag<I> implements Bag<I> {
    // Singly linked list node
    class Node {
        I data;
        Node next;
    }

    // fifo head
    private Node first;
    // fifo tail
    private Node last;
    private int N;

    public void add(I item) {
        Node oldLast = last;
        last = new Node();
        last.data = item;
        last.next = null;
        if (isEmpty()) first = last;
        else    oldLast.next = last;
        N++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // Additional method for provide more convenience

    public Iterator<I> iterator() {
        return new ListIterator<I>() ;
    }

    private class ListIterator<Item> implements Iterator {

        private Node current = first ;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item =  (Item) current.data;
            current = current.next;
            return item;
        }
    }
}
