/** Ex4.1.1: Calculates the longest string in an List61B using List61B class.
 *  @author vingo
 */
public class WordUtils {
	private static void calLongest(List61B<String> list) {
		int longestLength = 0;
		int indexLongest = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > longestLength) {
				longestLength = list.get(i).length();
				indexLongest = i;
			}
		}
		System.out.println(list.get(indexLongest));
    }
	
	public static void main(String[] args) {
		SLList<String> L = new SLList<>();
		L.addFirst("an");
		L.addFirst("apple");
		L.addFirst("tree");
		calLongest(L);
		L.print();
	}
}
