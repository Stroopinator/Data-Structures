package SimpleList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings({"rawtypes", "unused"})
public class SimpleList implements List {
    
    /**
     * SimpleNode definition of a single-linked list of Objects 
     */
    private class SimpleNode {
        private Object data;
        private SimpleNode next;
        
        private SimpleNode(Object data) {
            this(data,  null);
        }
        
        private SimpleNode(Object _data, SimpleNode _next) {
            data = _data;
            next = _next;
        }
    }
    
    /**
     * TODO: Class fields: Keep track of the head and tail of the list
     * TODO: and the number of nodes it contains.
     */
    private SimpleNode head;
    private SimpleNode tail;
    private int nodes;
    public SimpleList() {
        nodes = 0;
        head = null;
        tail = null;
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param element - element to be appended to this list.
     * @return true
     */
    @Override
    public boolean add(Object element) {
        // TODO: Implement interface method add
        if(tail == null){
            tail = new SimpleNode(element);
            head = tail;
            nodes++;
            return true;
        }
        tail.next = new SimpleNode(element);
        tail = tail.next;
        nodes++;
        return true;
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index - index at which the specified element is to be inserted.
     * @param element - element to be inserted.
     */
    @Override
    public void add(int index, Object element) {
        if(head == null){
            head =  new SimpleNode(element);
            tail =  head;
        }
        SimpleNode p = head;
        SimpleNode q = head;
        if(index > nodes){
            System.out.println("Index Out of Bounds");
            return;
        }
        //checks if the index is at the start of the list and replaces the head if it is
        if(index == 0){
            head = new SimpleNode(element);
            head.next = p;
            nodes++;
            return;
        }
        for(int i = 0; i < index; i++){
            q = p;
            p = p.next;
        }
        q.next = new SimpleNode(element);
        q.next.next = p;
        
        //checks if the index is at the end of the list and adds a tail if it is
        nodes++;
        // TODO: Implement interface method add
    }
    
    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        // TODO: Implement interface method clear
        head = null;
        tail = null;
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return.
     * @return the element at the specified position in this list.
     */
    @Override
    public Object get(int index) {
        // TODO: Implement interface method get
        SimpleNode p = head;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.data;
    }
    
    /**
     * Removes the element at the specified position in this list.
     * @param index - the index of the element to be removed.
     * @return the element previously at the specified position.
     */
    @Override
    public Object remove(int index) {
        // TODO: Implement interface method remove
        if(index > nodes){
            System.out.println("Index Out Of Bounds");
            return null;
        }
        SimpleNode p = head;
        SimpleNode q = head;
        //This is for when the index is 0 it detatches the head from the list;
        if(index == 0){
            q = head.next;
            head.next = null;
            head = q;
            nodes--;
            return p.data + "";
        }
        for(int i = 0; i < index; i++){
            q = p;
            p = p.next;
        }
        q.next = p.next;
        nodes--;
        return p.data + "";
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index - index of the element to replace.
     * @param element - element to be stored at the specified position.
     * @return the element previously at the specified position.
     */
    @Override
    public Object set(int index, Object element) {
        // TODO: Implement interface method set
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        // TODO: Implement interface method size
        return nodes;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement interface method isEmpty
        throw new RuntimeException("Not yet implemented");
    }

    // #region: Overrides not supported by the SimpleList
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    // #endregion: Overrides not supported by the SimpleList
}
