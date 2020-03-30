package stack;

public class LinkedListStack<I>  implements Stack<I>{

    class Node {
        I data;
        Node next;
        Node(I data) { this.data =  data;}
    }

    Node first;
    int size = 0;

    public void push(I item) {
        Node oldNode = first;
        first = new Node(item);
        first.next = oldNode;
        size++;
    }

    public I pop() {
        I myVal = first.data;
        first = first.next;
        size--;
        return myVal;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
