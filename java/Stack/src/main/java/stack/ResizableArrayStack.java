package stack;

import java.util.Iterator;

public class ResizableArrayStack<I>  implements Stack<I> {

    private I[] items;
    private int N;

    ResizableArrayStack(){
        items = (I[]) new Object[10];
        N = 0;
    }
    ResizableArrayStack(int initialCapacity){
        items = (I[]) new Object[initialCapacity];
        N = 0;
    }

    public void push(I item) {
        if ( N == items.length )
            resize(2*items.length);

        items[N++] = item;
    }

    public I pop() {
        I item = items[--N];
        items[N] = null;

        if ( N>0 && N == items.length/4 ) resize(items.length/2);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int len) {
        I[] copy = (I[]) new Object[len*2];
        for (int i = 0; i < N; i++)
            copy[i] = items[i];
        items = copy;
    }


    // Additional method for provide more convenience

    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<I> {
        private int i = N;

        public boolean hasNext() { return i > 0; }

        public I next() { return items[--i]; }
    }
}
