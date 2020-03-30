package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    public static void main(String[] args) {
        StdOut.println("Union find client") ;

        // REad which algorithm to be used
        String algorithm = StdIn.readString();
        // Read how many number of inputs
        int N = StdIn.readInt();
        UnionFind uf;

        if (algorithm.equalsIgnoreCase("qf")) {
            uf = new QuickFind(N);
        } else if (algorithm.equalsIgnoreCase("qu")) {
            uf = new QuickUnion(N);
        } if (algorithm.equalsIgnoreCase("wqu")) {
            uf = new WeightedQuickUnion(N);
        } else {
            // If no choice or wrong option, select weighted quick union with pathc comression
            // the most efficient one
            uf = new WeightedQuickUnionWithPathCompression(N);
        }

//        int N = StdIn.readInt();
//        UnionFind uf = new QuickFind(N);
        // Process for all connections
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p,q)) {
                uf.union(p,q);
                StdOut.println(p + " - " + q);
            }
        }
    }
}
