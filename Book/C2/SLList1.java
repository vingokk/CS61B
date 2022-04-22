/** List using sentinel. */
public class SLList {
	public static class IntNode {
	    public int item;
		public IntNode prev;
	    public IntNode next;
	    public IntNode(IntNode p, int i, IntNode n) {
		    item = i;
			prev = p;
		    next = n;
	    }
    }
	
	private int size;
	private IntNode sentinel;
	private IntNode last;
	
	public SLList() {
		sentinel = new IntNode(null, 0, null);
		last = sentinel;
		size = 0;
	}	
	
	public SLList(int x) {
		sentinel = new IntNode(null, 0, null);
		sentinel.next = new IntNode(sentinel, x, null);
		last = sentinel.next;
		size = 1;
	}
	
	/** Adds a new node to the front of list. */
	public void addFirst(int x) {
		size += 1;
		if (sentinel.next == null) {
			sentinel.next = new IntNode(sentinel, x, sentinel.next);
			last = last.next;
		}
		sentinel.next.prev = new IntNode(sentinel, x, sentinel.next);
		sentinel.next = sentinel.next.prev;
	}
	
	/** Retrieves the front item from the List. */
	public int getFirst() {
		return sentinel.next.item;
	}
	
	/** Adds an item to the end of the list. */
    public void addLast(int x) {
		size += 1;		
		last.next = new IntNode(last, x, null);
		last = last.next;
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
		return size;
	}
	public static void main(String[] args) {
		SLList L = new SLList();
		L.addFirst(5);
		L.addLast(20);
		System.out.println(L.size());
		System.out.println("");
	}
}