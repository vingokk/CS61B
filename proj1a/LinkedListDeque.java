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
    public LinkedListDeque(LinkedListDeque other) {

    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        size += 1;
        sentinel.next.prev = new TNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        size += 1;
        sentinel.prev.next = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
    }
    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }
    /** Shows all the item in the deque. */
    public void printDeque() {
        TNode p = sentinel.next;
        if (p == sentinel) {
            System.out.print("the Deque is empty");
        }
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print('\n');
    }
//    public static void main(String[] args) {
//        LinkedListDeque<Integer> D = new LinkedListDeque<>();
//        D.addFirst(10);
//        D.addFirst(5);
//        D.addLast(15);
//        D.addLast(20);
//        D.printDeque();
//    }
}

