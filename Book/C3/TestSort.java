/** Tests for Sort class.
 *  @author Joshhug
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    /** Tests the sort method of the Sort class. */
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    /** Tests the findSmallest method of the Sort class. */
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    /** Tests the swap method of the Sort class. */
    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }

//    public static void main(String[] args) {
//        testSort();
////        testFindSmallest();
////        testSwap();
//    }
}