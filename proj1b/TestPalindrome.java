import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testStringIsPalindrome() {
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("acca"));
        assertTrue(palindrome.isPalindrome("acbca"));
        assertFalse(palindrome.isPalindrome("accd"));
        assertFalse(palindrome.isPalindrome("acc"));
    }

    @Test
    public void testDequeIsPalindrome() {
        assertTrue(palindrome.isPalindrome(palindrome.wordToDeque(" ")));
        assertTrue(palindrome.isPalindrome(palindrome.wordToDeque("a")));
        assertTrue(palindrome.isPalindrome(palindrome.wordToDeque("acca")));
        assertTrue(palindrome.isPalindrome(palindrome.wordToDeque("acbca")));
        assertFalse(palindrome.isPalindrome(palindrome.wordToDeque("accd")));
        assertFalse(palindrome.isPalindrome(palindrome.wordToDeque("acc")));
    }

    @Test
    public void testCcIsPalindrome() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome(" ", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("abb", offByOne));
        assertTrue(palindrome.isPalindrome("&b%", offByOne));
        assertFalse(palindrome.isPalindrome("&bc", offByOne));
    }
}
