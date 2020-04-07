package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class MergeSort {

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];

        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

        Stopwatch watch = new Stopwatch();
        MergeSort.sort(a);
        double time = watch.elapsedTime();

        StdOut.println("Time taken is " + time);

        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }

    private static void sort(Comparable[] a) {
        Comparable aux[] = new Comparable[a.length] ;
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux,mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo,mid-1);
        assert isSorted(a, mid, hi);
        // Copy
        for (int k = lo; k<= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo ; k <=hi ; k++) {
            if ( i > mid )            a[k] = aux[j++] ;
            else if ( j > hi )        a[k] = aux[i++] ;
            else if (less(a[j],a[i])) a[k] = aux[j++] ;
            else                      a[k] = aux[i++] ;
        }
        assert isSorted(a, lo, hi);
    }

    private static boolean less(Comparable one, Comparable other) {
        return one.compareTo(other) < 0 ;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = 0; i<a.length; i++) {
            if (less(a[i+1],a[i]))
                return false;
        }
        return true;
    }
}
