package queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestClientQueue {
    public static void main(String[] args) {
        String className = args[0];
        Queue q = getQImpl(className);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(q.dequeue() + " ");
            else q.enqueue(s);

        }
    }

    private static Queue getQImpl(String className) {
        StdOut.println(className);
        if(className.equalsIgnoreCase("LinkedListQueue")) {
            StdOut.println("LL type");
            return new LinkedListQueue();
        } else {
            StdOut.println("Array type");
            return new ResizableArrayQueue();
        }
    }
}
