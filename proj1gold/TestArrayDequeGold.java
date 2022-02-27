import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *  Tests methods in the StudentArrayDeque and ArrayDequeSolution.
 *  @source Adopts codes from StudentArrayDeque.
 */
public class TestArrayDequeGold {
    private static int epochs = 500; // The number of calling methods.
    private static String message = ""; // Stores failure sequence.

    @Test
    public void test() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();

        for (int i = 0; i < epochs; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform(); // Produces a number between 0 and 1 randomly.
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                sad2.addLast(i);
                message += "addLast(" + i + ")\n";
                assertEquals(message, sad2.get(sad2.size() - 1), sad1.get(sad1.size() - 1));
            } else if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                sad2.addFirst(i);
                message += "addFirst(" + i + ")\n";
                assertEquals(message, sad2.get(0), sad1.get(0));
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (!sad1.isEmpty() && !sad2.isEmpty()) {
                    Integer actual = sad1.removeFirst();
                    Integer expected = sad2.removeFirst();
                    message += "removeFirst()\n";
                    assertEquals(message, expected, actual);
                }
            } else {
                if (!sad1.isEmpty() && !sad2.isEmpty()) {
                    Integer actual = sad1.removeLast();
                    Integer expected = sad2.removeLast();
                    message += "removeLast()\n";
                    assertEquals(message, expected, actual);
                }
            }
        }
    }
}
