package stack;

public interface Stack<I> {
    void push(I item);
    I pop();
    boolean isEmpty();
    int size();
}
