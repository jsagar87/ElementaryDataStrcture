package sort;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;

public class HeapSort {

    private static void sort(Comparable[] pq) {
        int n = pq.length;

        for (int k = n/2; k >= 1; k--) {
            sink(pq, k, n);
        }

        int k = n;
        while (k > 1) {
            exch(pq,1, k--);
            sink(pq,1, k);
        }
    }

    // Sink

    // We want to check if current node k is smaller then any of its children
    // 2k and 2k+1
    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    // Utility method
    private static boolean less(Comparable a[], int one, int other) {
        return a[one-1].compareTo(a[other-1]) < 0 ;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x-1];
        a[x-1] = a[y-1];
        a[y-1] = temp;
    }

    // Client to test
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch watch = new Stopwatch();
        HeapSort.sort(a);
        double time = watch.elapsedTime();
        StdOut.println("Time taken is " + time);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

    }
}
