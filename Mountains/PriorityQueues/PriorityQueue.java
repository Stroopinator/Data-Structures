package PriorityQueues;

public interface PriorityQueue <E extends Comparable<E>> {
    void add(E value);
    E remove();
    E peek();
    void clear();
    boolean isEmpty();
    int size();    
}
