public class IntList {
	public int first;
	public IntList rest;
	
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}
	
	public int size() {
		/** Returns the number of items in List using recursion. */
		if (this.rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}
	
	public int iterativeSize() {
		/** Returns the number of items in List using no recursion. */
		int totalSize = 1;
		IntList p = this;
		while(p.rest != null) {
			totalSize++;
			p = p.rest;
		}
		return totalSize;
	}
	
	public int get(int i) {
		/** Returns ith number of items in List using. */
		if (i == 0) {
			return first;
		}
		return this.rest.get(i-1);
	}
	
	/** Exercise 2.2.1: compare the method construction 
	 *  in Intlist to method construction in SSList.
	*/
	public IntList addFirst(int x) {
		IntList temp = new IntList(x, this);
		return temp;
	}
	
	public static void main(String[] args) {
		/* Backwards */
	    IntList L = new IntList(15, null);
        IntList L2 = new IntList(10, L);
		IntList L3 = new IntList(5, L2);
		IntList L4 = L3.addFirst(0);
		System.out.println(L4.get(0));
    }
}
