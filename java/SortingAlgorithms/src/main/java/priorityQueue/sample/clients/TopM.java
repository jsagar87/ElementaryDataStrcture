package priorityQueue.sample.clients;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import priorityQueue.MaxPQ;

import priorityQueue.UnorderedMaxPQ;

public class TopM {

    class Transaction implements Comparable<Transaction> {
        public Transaction(String line) {
            String[] tokens = line.split(".");
            if (tokens.length == 4) {
                StdOut.println("Input record all well :");
            }
            else {
                StdOut.println("Discard");
            }
        }

        public int compareTo(Transaction o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        MaxPQ<Transaction> pq = new UnorderedMaxPQ<Transaction>();

        int M = StdIn.readInt();
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            TopM.Transaction item = new TopM().new Transaction(line);
            pq.insert(item);
            if(pq.size()>M)
                pq.delMax();
        }
    }
}
