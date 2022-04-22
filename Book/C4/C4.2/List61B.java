/** This is a example called List61B for Interface. 
 *  @author vingo
 */
/* A Interface is a super class specifies what a list must be able to do, 
   but it doesn't provide any implementation for those behaviors. 
*/ 
public interface List61B<Item> {
	/** Inserts the item into the given position in
	 *  the list. If position is greater than the
	 *  size of the list, inserts at the end instead.
	 */
	public void insert(Item item, int position);

 	/** Adds x to the front of the list. */
 	public void addFirst(Item x);

 	/** Adds x to the end of the list. */
 	public void addLast(Item x);

	/** Returns the first item in the list. */
	public Item getFirst();

	/** Returns last item */
	public Item getLast();

	/** Returns the ith item in the list. */
 	public Item get(int i);
 	
 	/** Returns the size of the list. */
 	public int size();
	
	/** Deletes and returns last item. */
	public Item removeLast();
	
	/** Prints all items in the list. */ 
	default public void print() {
		for (int i = 0; i < size(); i += 1) {
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}
}