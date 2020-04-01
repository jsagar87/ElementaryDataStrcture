package queue;

public class LinkedListQueue<I> implements Queue<I> {

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

    public void enqueue(I item) {
        Node oldLast = last;
        last = new Node();
        last.data = item;
        last.next = null;
        if (isEmpty()) first = last;
        else    oldLast.next = last;
        N++;
    }

    public I dequeue() {
        if (isEmpty())
            return null;
        I item = first.data;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
}
