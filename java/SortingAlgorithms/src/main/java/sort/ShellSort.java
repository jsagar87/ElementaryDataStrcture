package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;

public class ShellSort {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch watch = new Stopwatch();
        ShellSort.sort(a);
        double time = watch.elapsedTime();
        StdOut.println("Time taken is " + time);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

    }

    private static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        StdOut.println();

        while (h<N/3) h = 3*h + 1; // N =30; then h = 1,4,13,..... 40,121
        StdOut.println("Sprint size h= " +h);
        while (h >= 1) {
            // h-sort array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }
    }

    private static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        int h = 1;


        while (h<N/3) h = 3*h + 1; // N =30; then h = 1,4,13,..... 40,121

        while (h >= 1) {
            // h-sort array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(comparator,a[j], a[j-h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }
    }

    private static boolean less( Comparable one, Comparable other) {
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
