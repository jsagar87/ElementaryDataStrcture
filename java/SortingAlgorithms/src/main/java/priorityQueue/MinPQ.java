package priorityQueue;

public abstract class MinPQ<Key extends Comparable<Key>> {

//    public MinPQ(){
//
//    }
//
//    public MinPQ(Key[] a){
//
//    }

    abstract public void insert(Key v);

    // return and remove smallest Key
    abstract public Key delMin();

    abstract public boolean isEmpty();

    abstract public Key min() ;

    abstract public int size();
}
