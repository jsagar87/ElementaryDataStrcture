package priorityQueue;

public abstract class MaxPQ<Key> {

//    public MaxPQ() {
//
//    }
//
//    public MaxPQ(Key key) {
//
//    }

    abstract public Key delMax();

    abstract public boolean isEmpty() ;

    abstract public Key max();

    abstract public int size() ;

    abstract public void insert(Key x);
}
