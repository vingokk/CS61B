/** Exercise4.4.1 & Exercise 4.4.2 & Exercise 4.4.3
 *  source: https://joshhug.gitbooks.io/hug61b/content/chap4/chap44.html
 *  @author vingo
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Test {
	
	/** Puts every word from the input file into a list. */
	public static List<String> getWords(String inputFileName) {
		List<String> L = new ArrayList<>();
		In input = new In(inputFileName);
		while (!input.isEmpty()) {
			// Throws Exception if there are only whitespaces left. 
			String s = input.readString();
			L.add(L.size(), s);
		}
		input.close();
		return L;
    }

	/** Counts how many unique words there are in the file. */
	public static void countUniqueWords(List<String> words) {
		Set<String> sets = new HashSet<String>();
		for (String s : words) {
			sets.add(s);
		}
		System.out.println(sets.size());
		
		// Prints all items in the list.
		// Raw for loop, for(a:arr) can bu used in the List.
		for (int i = 0; i < words.size(); i++) {
			System.out.print(words.get(i));
		}
		System.out.println();
    }
	
	/**  Finds the number of times each target word appears in the word list. */
	public static Map<String, Integer> collectWordCount(List<String> targets, List<String> words) {
		Map<String, Integer> maps = new HashMap<>();
		for (String s : targets) {
			int num = 0;
			for (String x : words) {
				if (x.equals(s)) {
					num++;
				}
			}
			maps.put(s, num);
		}
		return maps;
		
		/*  Codes by Josh hug. */
		// for (String t: target) {
			// counts.put(s, 0);
		// }
		// for (String s: words) {
			// if (counts.containsKey(s)) {
				// counts.put(word, counts.get(s)+1);
			// }
		// } 
	}
	
	public static void main(String[] args) {
		List<String> words = getWords("num.txt");
		List<String> targets = new ArrayList<>();
		targets.add("c");
		targets.add("1");	
		int num = collectWordCount(targets, words).get("1");
		System.out.println(num);
	}
}