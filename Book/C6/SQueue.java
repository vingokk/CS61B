/** Disc05: Implements Queue based on stacks.
 * h
 *  @author Vingo
 */

import java.util.Stack;

public class SQueue<E> {

    private int size;
    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();
    public SQueue() {
        super();
        size = 0;
    }
    
    /** Adds an element to the end of the queue. */
    public void push(E item) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack2.push(item);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        size += 1;
    }

    /** Pops the element of the front of the queue. */
    public E poll() {
        if (stack1.empty()) {
           return null;
        }
        return (stack2.pop());
    }
}
