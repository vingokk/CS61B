/** Array based list.
 *  @author Josh Hug & Vingo
 */

public class AList {
    /** Creates an empty list. */
    private int[] item;
    private int size;

    public AList() {
        item = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (item.length == size) {
            size += 1;
            int[] a = new int[size];
            System.arraycopy(item, 0, a, 0, size);
            item = a;
        }
        item[size] = x;
        size += 1;
    }

    public void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(item, 0, a, 0, size);
        item = a;
    }

    public void insertBack(int x) {
		int Refactor = 2;
        if (item.length == size) {
            resize(size * Refactor);
        }
        item[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return item[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int lastItem = getLast();
        size -= 1;
        return lastItem ;
    }
}
