/** Implements Deque(Double Ended Queuq) based on LinkedList.
 * @author vingo
 */
public class LinkedListDeque<T> {
    public class TNode {
        public T item;
        public TNode prev;
        public TNode next;
        public TNode(TNode p, T i, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    private TNode sentinel;
    private int size;
    /** Constructors. */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /** Creats a deep copy. */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        /* Copy. */
        for (int i = 0; i < other.size(); i++) {
            this.addLast(other.get(i));
        }
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next.prev = new TNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev.next = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }
    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }
    /** Shows all the item in the deque. */
    public void printDeque() {
        if (isEmpty()) {
            System.out.print("the Deque is empty");
        }
        TNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print('\n');
    }
    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return firstItem;
    }
    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T lastItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastItem;
    }
    /** Gets the item at the given index, where 0 is the front,
     *  1 is the next item, and so forth.
     *  If no such item exists, returns null. */
    public T get(int index) {
        /* If no such item exists. */
        if ((index < 0) || (index > size - 1) || isEmpty()) {
            return null;
        }
        TNode p = sentinel.next;
        while (index > 0) {
            index -- ;
            p = p.next;
        }
        return p.item;
    }

    /** Gets the item at the given index using recursion. */
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
    public T getRecursiveHelper(TNode p, int index) {
        if ((index < 0) || (index > size - 1) || isEmpty()) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

//    public static void main(String[] args) {
//        LinkedListDeque<Integer> D = new LinkedListDeque<>();
//        D.addFirst(10);
//        D.addFirst(5);
//        D.printDeque();
//        LinkedListDeque<Integer> F = new LinkedListDeque<>(D);
//        F.printDeque();
//    }
}

