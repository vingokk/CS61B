import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class TestArrayDequeGold {
    /**
     *  Tests methods in the StudentArrayDeque and ArrayDequeSolution.
     *  @source Adopts codes from StudentArrayDeque.
     */
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String s = "";
        for (int i = 0; i < 500; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                sad2.addLast(i);
                s += "addLast(" + i + ")\n";
                assertEquals(s, sad2.get(sad2.size() - 1), sad1.get(sad1.size() - 1));
            } else if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                sad2.addFirst(i);
                s += "addFirst(" + i + ")\n";
                assertEquals(s, sad2.get(0), sad1.get(0));
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (!sad1.isEmpty() && !sad2.isEmpty()) {
                    Integer x = sad1.removeFirst();
                    Integer y = sad2.removeFirst();
                    s += "removeFirst()\n";
                    assertEquals(s, y, x);
                }
            } else {
                if (!sad1.isEmpty() && !sad2.isEmpty()) {
                    Integer x = sad1.removeLast();
                    Integer y = sad2.removeLast();
                    s += "removeLast()\n";
                    assertEquals(s, y, x);
                }
            }
        }
    }
}

