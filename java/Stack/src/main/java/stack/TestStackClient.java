package stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestStackClient {
    public static void main(String[] args) {
        Stack<String> stack = stackFactory(args[0]);

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(stack.pop() + " ");
            else stack.push(s);
        }
    }

    private static Stack<String> stackFactory(String s) {
        if ( s.equalsIgnoreCase("ResizableArrayStack") )
            return new ResizableArrayStack();
        return new LinkedListStack<String>();
    }
}
