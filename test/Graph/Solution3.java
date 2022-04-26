/** Solution to Question_3. */
public class Solution3 {
    public static void main(String[] args) {
//         for Question3_1.
//        int[] property  = new int[14];
//         // [tActive, fHotel, fFood, F0, D0]
//        double[] parameter = {7, 165, 120, 3000, 10};
//        MyGraph<Node, Weight> G = GraphBuilder.buildQuestion3(property);
//        int[] path = {2, 3, 1, 0, 4, 6, 5, 7, 11, 9, 10, 12, 13};
//        Solver solver = new Solver(G, path, parameter);
//        solver.calMAXE();

        // for Question3_2.
        int[] property  = new int[14];
        // [tActive, fHotel, fFood, F0, D0]
        double[] parameter = {7, 220, 360, 10000, 10};
        MyGraph<Node, Weight> G = GraphBuilder.buildQuestion3_2(property);
        int[] path = {2, 3, 1, 0, 4, 6, 5, 7, 8, 11, 9, 10, 12, 13};
        Solver solver = new Solver(G, path, parameter);
        solver.calMAXE();
    }
}
