/** Implements Selection sort algorithm for stringArray.
 *  @author vingo
 */
public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sorts strings destructively starting from item index. */
    public static void sort(String[] x, int index) {
        if (x.length == index) {
            return;
        }
        //Find the smallest item.
        int smallest = findSmallest(x, index);
        //Move it to the front.
        swap(x, index, smallest);
        sort(x, index + 1);
    }

    /** Returns the smallest string in the array.
     *  @source Got Help with string compares from https://goo.gl/a7yBU5. */
    public static int findSmallest(String[] x, int index) {
        int smallest = index;
        for (int i = index; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    /** Swaps item[a] and item[b] from a given array. */
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}