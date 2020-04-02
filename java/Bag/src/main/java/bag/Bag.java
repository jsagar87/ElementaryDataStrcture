package bag;

public interface Bag<Item> extends Iterable {
    void add(Item x);
    int size();
    boolean isEmpty();
}
