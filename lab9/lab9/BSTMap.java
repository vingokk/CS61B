package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 * @author vingo
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            return getHelper(key, p.left);
        }
        if (key.compareTo(p.key) > 0) {
            return getHelper(key, p.right);
        }
        return p.value;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new  IllegalArgumentException("argument to containsKey() is null");
        }
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size += 1;
            return new Node(key, value);
        }
        if (key.compareTo(p.key) < 0) {
            p.left = putHelper(key, value, p.left);
        }
        else if (key.compareTo(p.key) > 0) {
            p.right = putHelper(key, value, p.right);
        } else {
            p.value = value;
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new  IllegalArgumentException("argument to containsKey() is null");
        }
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set keySet = new HashSet();
        return keySetHelper(root, keySet);
    }
    private Set<K> keySetHelper(Node p, Set s) {
        if(p.left != null) {
            s.add(p.left.key);
            keySetHelper(p.left, s);
        }
        s.add(p.key);
        if(p.right != null) {
            s.add(p.right.key);
            keySetHelper(p.right, s);
        }
        return s;
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        V min = get(key);
        root = removeHelper(key, root);
        return min;
    }

    /** Removes the node p and returns thr rest BSTMap. */
    private Node removeHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            p.left = removeHelper(key, p.left);
        }
        else if (key.compareTo(p.key) > 0) {
            p.right = removeHelper(key, p.right);
        } else {
            if (p.right == null) {
                return p.left;
            }
            Node temp = p;
            p = findMin(p.right);

            p.right = deleteMin(temp.right);
            p.left = temp.left;
        }
        return p;
    }

    /** Returns the minimal node in the BSTMap. */
    private Node findMin(Node p) {
        if(p.left != null) {
            return findMin(p.left);
        }
        return p;
    }

    /** Returns a BSTMap rooted in p without the minimal node. */
    private Node deleteMin(Node p) {
        if(p.left == null) {
            return p.right;
        }
        p.left = deleteMin(p.left);
        return p;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        if (get(key) == value) {
            return remove(key);
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    /** Prints the map in order of increasing key. */
    public void printInOrder() {
        printInOrder(root);
    }

    private Node printInOrder(Node p) {
        if (p == null) {
            return null;
        }
        printInOrder(p.left);
        print(p);
        printInOrder(p.right);
        return null;
    }

    private void print(Node p) {
        if(p == null){
            System.out.print("null");
        }
        System.out.print(p.key + " ");
    }
}
