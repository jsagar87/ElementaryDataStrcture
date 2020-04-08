package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;

public class SelectionSort {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch watch = new Stopwatch();
        SelectionSort.sort(a);
        double time = watch.elapsedTime();
        StdOut.println("Time taken is " + time);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

    }

    private static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
               if (less(a[j], a[i])) exch(a, i, j);
            }
        }
    }

    private static void sort(Object[] a, Comparator comparator) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (less(comparator, a[j], a[i])) exch(a, i, j);
            }
        }
    }

    private static boolean less(Comparable one, Comparable other) {
        return one.compareTo(other) < 0 ;
    }

    private static boolean less(Comparator comparator, Object one, Object other) {
        return comparator.compare(one, other) < 0 ;
    }

    private static void exch(Object[] a, int x, int y) {
        Object temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
