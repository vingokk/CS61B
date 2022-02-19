public class ArrayDeque<T> {
    @SuppressWarnings("unchecked")
    private T[] items = (T[]) new Object[8];
    private int nextFirst;
    private int nextLast;
    private int size;
    /** Constructor. */
    public ArrayDeque() {
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isFull()) {
            upsize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    /** Returns the index after the given index. */
    public int plusOne(int index) {
        /* if index == items.length -1, return 0. */
        return (index + 1) % items.length;
    }
    /** Returns the index before the given index. */
    public int minusOne(int index) {
        /* if index == 0, return items.length -1. */
        return (index - 1 + items.length) % items.length;
    }
    /** Resizes the deque by capacity, size remains the same. */
    public void resize(int capacity) {
        @SuppressWarnings("unchecked")
        T[] a = (T[]) new Object[capacity];
        int head = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[head];
            head = plusOne(head);
        }
        items = a;
        nextFirst = a.length - 1;
        nextLast = size;
    }
    /** Expands the deque by refactor */
    public void upsize() {
        int refactor = 2;
        resize(refactor * items.length);
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isFull()) {
            upsize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }
    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }
    /**  Returns true if deque is full, false otherwise. */
    public boolean isFull() {
        return size == items.length;
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
        int head = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[head] + " ");
            head = plusOne(head);
        }
        System.out.print('\n');
    }
    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        /* The index of the first number in the deque. */
        int head = plusOne(nextFirst);
        T itemFirst = items[head];
        items[head] = null;
        nextFirst = head;
        size -= 1;
        if (isRedundant()) {
            downsize();
        }
        return itemFirst;
    }
    /** Returns true if the usage is less than 0.25 and
     *  the length of deque is more than 16, false otherwise.
     *  */
    public boolean isRedundant() {
        double ratioUsage = 1.0 * size / items.length;
        return  ratioUsage<= 0.25 && items.length >= 16;
    }
    /** Shrinks the deque by refactor.*/
    public void downsize() {
        /* Halves the size of the whole deque. */
        double refactor = 0.5;
        resize((int)(items.length * refactor));
    }
    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        /* The index of the last item in the deque. */
        int tail = minusOne(nextLast);
        T itemLast = items[tail];
        items[tail] = null;
        nextLast = tail;
        size -= 1;
        if (isRedundant()) {
            downsize();
        }
        return itemLast;
    }
    /** Gets the item at the given index, where 0 is the front,
     *  1 is the next item, and so forth.
     *  If no such item exists, returns null.
     */
    public T get(int index) {
        if (index > size) {
            return null;
        }
        int i = plusOne(nextFirst) + index;
        if (i > items.length) {
            return items[i - items.length];
        }
        return items[i];
    }
//    public static void main(String[] args) {
//        ArrayDeque<Integer> D = new ArrayDeque<>();
//        for (int i = 0; i < 16; i++) {
//            D.addLast(i);
//        }
//        for (int i = 0; i < 15; i++) {
//            D.removeFirst();
//        }
//        for (int i = 0; i < 16; i++) {
//            D.addFirst(i);
//        }
//        System.out.println(D.size());
//        D.printDeque();
//    }
}
