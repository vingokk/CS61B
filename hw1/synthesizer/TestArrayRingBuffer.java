package synthesizer;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        arb.enqueue(5);
        arb.enqueue(10);
        arb.enqueue(10);
//        arb.dequeue();
//        arb.dequeue();
//        arb.dequeue();
//        arb.enqueue(10);
        assertEquals(Integer.valueOf(5), arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    // public static void main(String[] args) {
    //     jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    // }
} 
