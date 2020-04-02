package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class InsertionSort {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch watch = new Stopwatch();
        InsertionSort.sort(a);
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

    private static boolean less(Comparable one, Comparable other) {
        return one.compareTo(other) < 0 ;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
