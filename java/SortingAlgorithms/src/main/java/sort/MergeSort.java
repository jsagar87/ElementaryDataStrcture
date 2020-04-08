package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;

public class MergeSort {

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];

        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

//        for (int i = 0; i < N; i++)
//            a[i] = new Double(N - i);


        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

        StdOut.println("----------------");
        Stopwatch watch = new Stopwatch();

        MergeSort.sort(a);
        double time = watch.elapsedTime();

        StdOut.println("Time taken is " + time);

        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }

    public static void sort(Comparable[] a) {
        Comparable aux[] = new Comparable[a.length] ;
        sort(a, aux, 0, a.length-1);
    }

    public static void sort(Object[] a, Comparator comparator) {
        Comparable aux[] = new Comparable[a.length] ;
        sort(comparator, a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux,mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void sort(Comparator comparator, Object[] a, Object[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(comparator, a, aux, lo, mid);
        sort(comparator, a, aux,mid+1, hi);
        merge(comparator,a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo,mid);
        assert isSorted(a, mid+1, hi);
        // Copy
        for (int k = lo; k<= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo ; k <=hi ; ++k) {
            if ( i > mid )                a[k] = aux[j++] ;
            else if ( j > hi )            a[k] = aux[i++] ;
            else if (less(aux[j],aux[i])) a[k] = aux[j++] ;
            else                          a[k] = aux[i++] ;
        }
        assert isSorted(a, lo, hi);
    }

    private static void merge(Comparator comparator, Object[] a, Object[] aux, int lo, int mid, int hi) {
        assert isSorted(comparator, a, lo,mid);
        assert isSorted(comparator, a, mid+1, hi);
        // Copy
        for (int k = lo; k<= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo ; k <=hi ; ++k) {
            if ( i > mid )                             a[k] = aux[j++] ;
            else if ( j > hi )                         a[k] = aux[i++] ;
            else if (less(comparator, aux[j],aux[i]))  a[k] = aux[j++] ;
            else                                       a[k] = aux[i++] ;
        }
        assert isSorted(comparator, a, lo, hi);
    }

    private static boolean less(Comparable one, Comparable other) {
        return one.compareTo(other) < 0 ;
    }

    private static boolean less(Comparator comparator, Object one, Object other) {
        return comparator.compare(one, other) < 0 ;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i<=hi; i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    private static boolean isSorted(Comparator comparator, Object[] a, int lo, int hi) {
        for (int i = lo+1; i<=hi; i++) {
            if (less(comparator, a[i],a[i-1]))
                return false;
        }
        return true;
    }
}
