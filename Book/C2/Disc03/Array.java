/** Disc03: More Practice with Array.
 *  @author vingo
 */
public class Array {
	/** Inserts an int item into an int[] arr at the given position. */
	public static int[] insert(int[] arr, int item, int position) {
		int[] arrNew = new int[arr.length + 1];
		System.arraycopy(arr, 0, arrNew, 0, position);
		arrNew[position] = item;
		System.arraycopy(arr, position, arrNew, position + 1, arr.length - position);
		return arrNew;
	}	
	
	/** Destructively reverses the items in array. */
	public static void reverse(int[] arr) {
		for (int i = 0; i < (arr.length / 2); i++) {
			int temp = arr[i];
		    arr[i] = arr[arr.length - i -1];
		    arr[arr.length - i -1] = temp;
		}
	}
	
	/** Replicates(int[] arr) that replaces the number at index i with arr[i] copies of itself. */
	public static int[] replicate(int[] arr) {
		int sum = 0;
		for (int item : arr) {
			sum += item;
		}
	    int[] arrCopy = new int[sum];
		int i = 0;
		for (int item : arr) {
			for (int count = 0; count < item; count++) {
				arrCopy[i] = item;
				i++;
			}
		}
		return arrCopy;
	}
	
	
	/** Shows all the item of the array. */
	public static void show(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i]);
			i++;
		}
		System.out.print('\n');
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		int[] arr = insert(array, 5, 4);
		show(arr);
		reverse(arr);
		show(arr);
		arr = replicate(arr);
		show(arr);
		
	}
}