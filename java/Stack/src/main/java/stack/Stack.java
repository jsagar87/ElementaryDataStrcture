package stack;

public interface Stack<I> extends Iterable {
    void push(I item);
    I pop();
    boolean isEmpty();
    int size();
}
