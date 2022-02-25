public class Palindrome {
    /** Converts String to Deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
    /** Returns true if the given word is a palindrome, false otherwise. */
    public boolean isPalindrome(String word) {
        Palindrome p = new Palindrome();
        Deque<Character> d = p.wordToDeque(word);
        return isPalindrome(d);
    }

    /** Returns true if the given deque is a palindrome, false otherwise. */
    public boolean isPalindrome(Deque<Character> deques) {
        if (deques.size() == 0 || deques.size() == 1) {
            return true;
        }
        if (deques.removeFirst() == deques.removeLast()) {
            return isPalindrome(deques);
        }
        return false;
    }
    /** Returns true if the word is a palindrome according to the character comparator. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome p = new Palindrome();
        Deque<Character> d = p.wordToDeque(word);
        return isPalindrome(d, cc);
    }
    /** Returns true if the given deque is a palindrome according to the character comparator,
     *  false otherwise. */
    public boolean isPalindrome(Deque<Character> deques, CharacterComparator cc) {
        if (deques.size() == 0 || deques.size() == 1) {
            return true;
        }
        if (cc.equalChars(deques.removeFirst(), deques.removeLast())) {
            return isPalindrome(deques);
        }
        return false;
    }
}

