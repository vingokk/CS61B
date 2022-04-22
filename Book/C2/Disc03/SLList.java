/** Disc03: More Practice with Linked Lists.
 *  @author vingo
 */
public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
        this.item = item;
        this.next = next;
        }
    }

    private IntNode first;

    public SLList() {
	    first = null;
    }
	public void addFirst(int x) {
		first = new IntNode(x, first);
	}
	
	/** Reverses the elements of the list using recursion. */
	// public void reverse() {
		// IntNode p = reverseHelper(first);
		// p.next = null;
	// }

	// public IntNode reverseHelper(IntNode p) {
		// if (p == null || p.next == null) {
			// first = p;
			// return p;
		// }
		// /* The front Note. */
		// IntNode frontNode = reverseHelper(p.next); 
		// frontNode.next = p; 
		// return p;	
	// }	
	
	/** Reverses the elements of the list using iteration. */
	public void reverse() {
		IntNode p = first;
		IntNode frontNode = null;
		while (p != null) {
		    IntNode backNode = p.next;
		    p.next = frontNode;
			frontNode = p;
			p = backNode;		
		}
		first = frontNode;
	}
	
	/** Shows all the item in the list. */
	public void show(){
	    IntNode p = first;
		while (p != null) {
			System.out.println(p.item);
			p = p.next;
		}
    }
		
	public static void main(String[] args){
	SLList L = new SLList();
	L.addFirst(30);
	L.addFirst(25);
	L.addFirst(20);
	L.addFirst(15);
	L.addFirst(10);
	L.show();
	L.reverse();
	L.show();
    }
}
