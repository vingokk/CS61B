/** Single Linked-List.
 *  @author Josh Hug
 */
/* An SLList is a list of integers, which hides the terrible truth
   of the nakedness within. 
*/
public class SLList<Blorp> implements List61B<Blorp> {
	private class Node {
		public Blorp Blorp;
		public Node next;

		public Node(Blorp i, Node n) {
			Blorp = i;
			next = n;
		}
	} 

	/* The first Blorp (if it exists) is at sentinel.next. */
	private Node sentinel;
	private int size;

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new Node(null, null);
		size = 0;
	}

	public SLList(Blorp x) {
		sentinel = new Node(null, null);
		sentinel.next = new Node(x, null);
		size = 1;
	}

	 /** Inserts the Blorp into the given position in
	  *  the list. If position is greater than the
	  *  size of the list, inserts at the end instead.
	  */
	 @Override
	 public void insert(Blorp Blorp, int position) {
		 Node p = sentinel;
		 while (position > 1 && p.next != null) {
			 position--;
			 p = p.next;
		 }
		 Node newNode = new Node(Blorp, p.next);
		 p.next = newNode;
	 }

 	/** Adds x to the front of the list. */
	@Override
 	public void addFirst(Blorp x) {
 		sentinel.next = new Node(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Adds x to the end of the list. */
	@Override
 	public void addLast(Blorp x) {
 		size = size + 1; 		

 		Node p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new Node(x, null);
 	}

	 /** Returns the first Blorp in the list. */
	 @Override
	 public Blorp getFirst() {
		 return sentinel.next.Blorp;
	 }

	 /** Returns the back node of our list. */
	 private Node getLastNode() {
		 Node p = sentinel;

		 /* Move p until it reaches the end. */
		 while (p.next != null) {
			 p = p.next;
		 }
		 return p;
	 }

	 /** Returns last Blorp */
	 @Override
	 public Blorp getLast() {
		 Node back = getLastNode();
		 return back.Blorp;
	 }

	 /** Returns the ith Blorp in the list. */
	 @Override
 	public Blorp get(int i) {
		return get(i, sentinel.next);
	}

	private Blorp get(int i, Node p) {
 		if (i == 0) {
 			return p.Blorp;
		}
 		return get(i - 1, p.next);
	}
 	
 	/** Returns the size of the list. */
	@Override
 	public int size() {
 		return size;
 	}

	 /** Deletes and returns last Blorp. */
	 @Override
	 public Blorp removeLast() {
		 Node back = getLastNode();
		 if (back == sentinel) {
			 return null;
		 }

		 Node p = sentinel;

		 while (p.next != back) {
			 p = p.next;
		 }
		 p.next = null;
		 return back.Blorp;
	 }
	 
	@Override
	public void print() {
		for (Node temp = sentinel.next; temp != null; temp = temp.next) {
			System.out.print(temp.Blorp + " ");
		}
		System.out.println();
	}
}
