/** Solution to Question_2. */
public class Solution2 {
    public static void main(String args[]) {
        // Initialize Graph.
        int[] property  = new int[12];
        MyGraph<Node, Weight> G = GraphBuilder.buildQuestion2(property);
        int[] path = {2, 3, 1, 0, 4, 6, 5, 7, 8, 11, 9, 10};
        Solver solver = new Solver(G, path);
        solver.calMAXE();
    }
}
