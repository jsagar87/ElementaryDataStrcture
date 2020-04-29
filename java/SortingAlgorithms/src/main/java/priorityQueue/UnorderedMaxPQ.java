package priorityQueue;

public class UnorderedMaxPQ<Key extends Comparable<Key>> extends MaxPQ<Key> {

    private Key[] pq;

    private int N;

    public Key delMax() {
        Key max = pq[N-1];
        for (int i = N-2 ; i > 0 ; i--) {
            if (max.compareTo(pq[i]) < 0) {
                Key temp = pq[i];
                pq[i] = max;
                max = temp;
            }
        }
        pq[N] = null;
        N--;
        return max;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public Key max() {
        Key max = pq[N-1];
        for (int i = N-2 ; i > 0 ; i--) {
            if (max.compareTo(pq[i]) < 0) {
                Key temp = pq[i];
                pq[i] = max;
                max = temp;
            }
        }
        return max;
    }

    public int size() {
        return N;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

}
