package PriorityQueues;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapPriorityQueue <E extends Comparable<E>> implements PriorityQueue<E> {
    private E[] elements;
    private int size;

    // #region - helper methods
    private int left(int index) {
        return 2 * index;
    }

    private int right(int index) {
        return 2 * index + 1;
    }

    private int parent(int index) {
        return index / 2;
    }

    private boolean hasParent(int index) {
        return (index > 1);
    }

    private boolean hasLeft(int index) {
        return (size >= left(index));
    }

    private boolean hasRight(int index) {
        return (size >= right(index));
    }

    private void swap(int index1, int index2) {
        E temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }
    // #endregion - helper methods

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public HeapPriorityQueue(Class eClass) {
        elements = (E[])Array.newInstance(eClass, 10);
        size = 0;
    }

    @Override
    public void add(E value) {
        if (size == elements.length-1 ) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
        elements[++size]=value;
        int index = size;
        while(hasParent(index)) {
            int parentIndex = parent(index);
            if (elements[index].compareTo(elements[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    @Override
    public E remove() {
        if(isEmpty()) {
            return null;
        }

        E result = elements[1];
        elements[1] = elements[size--];
        int index = 1;
        while(hasLeft(index)) {
            int leftIndex = left(index);
            int rightIndex = right(index);
            int childIndex = hasRight(index) && (elements[rightIndex].compareTo(elements[leftIndex]) < 0)
                        ? rightIndex
                        : leftIndex;
            if (elements[index].compareTo(elements[childIndex]) <= 0) {
                break;
            }
            swap(index, childIndex);
            index = childIndex;
        }

        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[1];
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }
}
