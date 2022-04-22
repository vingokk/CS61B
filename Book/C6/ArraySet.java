/** Implements Set based on Array.
 *  @author Josh hug & Vingo
 */
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] values;
    private int size;

    public ArraySet() {
        values = (T[]) new Object[100];
        size = 0;
    }

    /** Returns true if this set contains the value. */
    public boolean contains(T x) {
//        for (T value : values) {
//            if (value.equals(x)) {
//                return true;
//            }
//        }
        // Using naive for loop avoids nullPointer Exception.
        // Size equals 0 when values[0] can be null, in that case,
        // the following loop won't be entered.
        for (int i = 0; i < size; i += 1) {
            if (values[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /** Adds the value to the set if not already present. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can not add null");
        }
        if (this.contains(x)) {
            return;
        }
        values[size] = x;
        size += 1;
    }

    /** Returns the number of values. */
    public int size() {
        return size;
    }

    /** Returns an iterator (a.k.a. seer) into ME */
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        //why ArraySetIterator<T> is wrong?
        private int wizpos;

        public ArraySetIterator() {
            wizpos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizpos < size;
        }

        @Override
        public T next() {
            T returnItem;
            returnItem= values[wizpos];
            wizpos += 1;
            return returnItem;
        }
    }

    /** Returns a string whose elements separated by commas inside  curly braces. */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        for (int i = 0; i < size - 1; i +=1) {
            s.append(values[i]);
            s.append(", ");
        }
        s.append(values[size-1]);
        s.append("}");
        return s.toString();
    }

    /** Returns true if both given object and ArraySet have the same elements,
     *  false otherwise .*/
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (this.size != o.size()) {
            return false;
        }
        for (T value : this) {
            if(!o.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /* EXTRA VIDEO CODE
    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    } */

    /* EXTRA VIDEO CODE
    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    } */

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);

        //equals
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));
    }
}
