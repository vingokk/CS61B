/** List using no sentinel. */
public class SLList1 {
	public static class IntNode {
	    public int item;
	    public IntNode next;
	    public IntNode(int i, IntNode n) {
		    item = i;
		    next = n;
	    }
    }
	
	private IntNode first;
	private int size;
	
	public SLList() {
		first = null;
		size = 0;
	}	
	
	public SLList(int x) {
		first = new IntNode(x, null);
		size = 1;
	}
	
	/** Adds a new node to the front of list. */
	public void addFirst(int x) {
		size += 1;
		first = new IntNode(x ,first);
	}
	
	/** Retrieves the front item from the List. */
	public int getFirst() {
		return first.item;
	}
	
	/** Adds an item to the end of the list. */
    public void addLast(int x) {
		size += 1;
		if (first == null) {
			first = new IntNode(x, null);
			return;
		}
		
		IntNode p = first;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
    }

    /** Returns the number of items in the list using recursion. */
    // public int size(IntNode p) {
        // if (p.next == null) {
			// return 1;
		// }
		// return 1 + size(p.next);
    // }
	
	// public int size(){
		// return size(first);
	// }
    public int size() {
		return size;
	}
	public static void main(String[] args) {
		SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);
		L.addLast(20);
		System.out.println(L.size());
		System.out.println(L.first.next.next.next.item);
	}
}