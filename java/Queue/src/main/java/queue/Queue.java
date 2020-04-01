package queue;

public interface Queue<I> {
    void enqueue(I item);
    I dequeue();
    boolean isEmpty();
    int size();
}
