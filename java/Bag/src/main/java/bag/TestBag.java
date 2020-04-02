package bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class TestBag {
    public static void main(String[] args) {

        Bag<Integer> bag = new LinkedListBag<Integer>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        bag.add(6);
        bag.add(7);
        Iterator<Integer> i = bag.iterator();
        while (i.hasNext())
        {
            StdOut.println(i.next());
        }

        // Seperator
        StdOut.println("----------------------");
        Bag<Integer> bag2 = new ResizableArrayBag<Integer>();
        bag2.add(1);
        bag2.add(2);
        bag2.add(3);
        bag2.add(4);
        bag2.add(5);
        bag2.add(6);
        bag2.add(7);
        Iterator<Integer> i2 = bag2.iterator();
        while (i2.hasNext())
        {
            StdOut.println(i2.next());
        }
    }
}
