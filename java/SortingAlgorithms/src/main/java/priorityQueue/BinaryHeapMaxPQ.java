package priorityQueue;


import java.util.Comparator;

/***
 * - Heap ordered
 * - Parent key is > children key
 * - Array representation
 *      > Indices start at index 1
 *      > Takes nodes in level order
 *      > No explicit links needed (e.g. link in case of class Node{ Node link; Key Data }
 */
public class BinaryHeapMaxPQ<Key extends Comparable> extends MaxPQ<Key>  {

    Key arr[];
    int N;

    public BinaryHeapMaxPQ(int sz) {
        this.N = 0;
        this.arr = (Key[]) new Object[sz + 1];
    }

    /**
     * Time complexity O(log N)
     *
     * @param x
     */
    public void insert(Key x) {
        this.arr[++N] = x;
        swim(this.arr, N);
    }

    /**
     * Time complexity O(log N)
     *
     * @return
     */
    public Key delMax() {
        Key max = arr[1];
        exch(arr,1,N--);
        sink(arr, 1);
        arr[N+1] = null; // deleting by nulling
        return max;
    }

    /**
     * Time complexity O(1)
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Time complexity O(1)
     *
     * @return
     */
    public Key max() {
        return arr[1];
    }

    /**
     * Time complexity O(1)
     *
     * @return
     */
    public int size() {
        return N;
    }

    // Swim and sink
    private void swim(Comparable[] a, int k) {     // k is index
        while ( k>1 && less(a[k/2], a[k])) {
            exch(a,k/2, k);// Elements exchanged now also update k to parent
            k = k/2;
        }
    }

    // We want to check if current node k is smaller then any of its children
    // 2k and 2k+1
    private void sink(Comparable[] a, int k) {     // k is index of current node
        // Node at k will continue doing this till its right position
        // or k is on leaf i.e. N
        while (2*k<=this.N) {
            // Decide which child of two
            int j = 2*k;
            if (j<N && less(a[j],a[j+1])) j++;

            // now check and replace with child if large
            if (!less(a[k],a[j])) break;
            exch(a,j, k);
            k=j;

        }

    }

    // Utility method
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
