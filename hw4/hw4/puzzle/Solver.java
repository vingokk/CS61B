package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import java.util.Comparator;
import java.util.Stack;
import java.util.HashMap;

public class Solver {
    private MinPQ<Node> pq;
    private Node target;
    private Node source;
    private int numOfEnqueued = 0;
    private HashMap<WorldState, Integer> map = new HashMap<>();

    private class Node {
        WorldState state;
        int move; // the number of moves made to reach this world state
        Node prev; // a reference to previous search node

        Node(WorldState state, int move, Node prev) {
            this.state = state;
            this.move = move;
            this.prev = prev;
        }
    }

    public Solver(WorldState initial) {
        pq = new MinPQ<>(new Comparator<Node>() {
            @Override
            /** Returns a negative integer, zero, or a positive integer
             *  as the first argument is less than, equal to, or greater than the second.
             */
            public int compare(Node t1, Node t2) {
                int o1 = t1.move + getEdtg(t1);
                int o2 = t2.move + getEdtg(t2);
                return o1 - o2;
            }

            /** Avoid recomputing the estimatedDistanceToGoal() result
             *  by caching its value in the map.
             */
            private int getEdtg(Node p) {
                if (!map.containsKey(p.state)) {
                    map.put(p.state, p.state.estimatedDistanceToGoal());
                }
                return map.get(p.state);
            }
        });

        source = new Node(initial, 0, null);
        pq.insert(source);
        numOfEnqueued += 1;

        while (!pq.isEmpty()) {
            Node x = pq.delMin();
            if (x.state.isGoal()) {
                target = x;
                break;
            }
            for (WorldState rest : x.state.neighbors()) {
                // A crytical step to optimization where the pq won't enqueue the current node's parent or nodes
                // equal to its parent
                if (x.prev != null && rest.equals(x.prev.state)) {
                    continue;
                }
                pq.insert(new Node(rest, x.move + 1, x));
                numOfEnqueued += 1;
            }
        }
    }

    public int moves() {
        return target.move;
    }

    public Iterable<WorldState> solution() {
        Stack<WorldState> l1 =  new Stack<>();
        Stack<WorldState> l2 =  new Stack<>();
        Node p = target;
        while (p != null) {
            l1.push(p.state);
            p = p.prev;
        }

        while (!l1.isEmpty()) {
            l2.push(l1.pop());
        }
        return l2;
    }

    public int getNumOfEnqueued() {
        return numOfEnqueued;
    }
}
