/** List using 2 sentinels. */
public class DLList{
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
	private IntNode sentF;
	private IntNode sentB;
	
	public SLList() {
		sentF = new IntNode(null, 0, null);
		sentB = new IntNode(null, 0, null);
		sentF.next = sentB;
		sentB.prev = sentF;
		size = 0;
	}	
	
	public SLList(int x) {
		sentF = new IntNode(null, 0, null);
		sentF.next = new IntNode(sentF, x, null);
		sentB = new IntNode(null, 0, null);
		sentF.next.next = sentB;
		sentB.prev = sentF.next.next;
		size = 1;
	}
	
	/** Adds a new node to the front of list. */
	public void addFirst(int x) {
		size += 1;
		sentF.next.prev = new IntNode(sentF, x, sentF.next);
		sentF.next = sentF.next.prev;
	}
	
	/** Retrieves the front item from the List. */
	public int getFirst() {
		return sentF.next.item;
	}
	
	/** Adds an item to the end of the list. */
    public void addLast(int x) {
		size += 1;		
		sentB.prev.next = new IntNode(sentB.prev, x, sentB);
		sentB.prev = sentB.prev.next;
    }

    // /** Returns the number of items in the list using recursion. */
    // public int size() {
		// return size;
	// }
	public static void main(String[] args) {
		SLList L = new SLList();
		L.addFirst(10);
		L.addFirst(20);
		L.addLast(50);
		// System.out.println(L.size());
		System.out.println(L.sentB.prev.item);
	}
}