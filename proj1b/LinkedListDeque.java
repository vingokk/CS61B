/** Implements Deque(Double Ended Queue) based on LinkedList.
 * @author vingo
 */
public class LinkedListDeque<Item> implements Deque<Item> {
    private class TNode {
        private Item item;
        private TNode prev;
        private TNode next;

        public TNode(TNode p, Item i, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    /**
     * Constructors.
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Adds an item of type Item to the front of the deque.
     */
    @Override
    public void addFirst(Item item) {
        sentinel.next.prev = new TNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    /**
     * Adds an item of type Item to the back of the deque.
     */
    @Override
    public void addLast(Item item) {
        sentinel.prev.next = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Shows all the item in the deque.
     */
    @Override
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

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return firstItem;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item lastItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastItem;
    }

    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    @Override
    public Item get(int index) {
        /* If no such item exists. */
        if ((index < 0) || (index > size - 1) || isEmpty()) {
            return null;
        }
        TNode p = sentinel.next;
        while (index > 0) {
            index -= 1;
            p = p.next;
        }
        return p.item;
    }

    /**
     * Gets the item at the given index using recursion.
     */
    public Item getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    private Item getRecursive(TNode p, int index) {
        if ((index < 0) || (index > size - 1) || isEmpty()) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);
    }
}
