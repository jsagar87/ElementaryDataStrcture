package sort.sample.clients;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import sort.InsertionSort;

public class Experiment {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch watch = new Stopwatch();
        Insertion.sort(a);
        double time = watch.elapsedTime();
        StdOut.println("Time taken is " + time);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
