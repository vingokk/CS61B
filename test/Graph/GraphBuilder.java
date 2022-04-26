/** Class that builds a graph with a certain path and weights,
 *  which depicts how the man travelled to the cities.
 */
public class GraphBuilder {
    /** Graph for Question1. */
    public static MyGraph<Node, Weight> buildQuestion1(int[] path) {
        MyGraph<Node, Weight> G;
        G = new MyGraph<>(path.length);

        Node n0 = new Node(0, 1, 0);
        Node n1 = new Node(1, 1.5, 70);
        Node n2 = new Node(2, 2, 90);
        Node n3 = new Node(3, 3, 0);
        Node n4 = new Node(4, 5, 90);
        Node n5 = new Node(5, 2.5, 0);
        Node n6 = new Node(6, 5, 30);
        Node n7 = new Node(7, 2.5, 100);
        Node n8 = new Node(8, 3.5, 140);
        Node n9 = new Node(9, 2, 80);
        Node n10 = new Node(10, 2.5, 30);
        Node n11 = new Node(11, 5, 115);

        // path = {2,3,1,0,4,6,5,7,11,9,10};
        Weight w23 = new Weight(0.77, 1);
        Weight w31 = new Weight(0.9, 1);
        Weight w10 = new Weight(0.13, 1);
        Weight w04 = new Weight(2.9, 84);
        Weight w46 = new Weight(0.53, 1);
        Weight w65 = new Weight(0.42, 1);
        Weight w57 = new Weight(5.2, 170);
        Weight w78 = new Weight(2.78, 448);
        Weight w811 = new Weight(5, 12);
        Weight w119 = new Weight(1.23, 15);
        Weight w910 = new Weight(4, 26);

        G.addEdge(n2, n3, w23);
        G.addEdge(n3, n1, w31);
        G.addEdge(n1, n0, w10);
        G.addEdge(n0, n4, w04);
        G.addEdge(n4, n6, w46);
        G.addEdge(n6, n5, w65);
        G.addEdge(n5, n7, w57);
        G.addEdge(n7, n8, w78);
        G.addEdge(n8, n11, w811);
        G.addEdge(n11, n9, w119);
        G.addEdge(n9, n10, w910);
        return G;
    }

    /** Graph for Question2. */
    public static MyGraph<Node, Weight> buildQuestion2(int[] path) {
        MyGraph<Node, Weight> G;
        G = new MyGraph<>(path.length);
        Node n0 = new Node(0, 1, 0 * 3);
        Node n1 = new Node(1, 1.5, 70 * 3);
        Node n2 = new Node(2, 2, 90 * 3);
        Node n3 = new Node(3, 3, 0 * 3);
        Node n4 = new Node(4, 5, 90 * 3);
        Node n5 = new Node(5, 2.5, 0 * 3);
        Node n6 = new Node(6, 5, 30 * 3);
        Node n7 = new Node(7, 2.5, 100 * 3);
        Node n8 = new Node(8, 3.5, 140 * 3);
        Node n9 = new Node(9, 2, 80 * 3);
        Node n10 = new Node(10, 2.5, 30 * 3);
        Node n11 = new Node(11, 5, 115 * 3);

        // path = {2,3,1,0,4,6,5,7,8,11,9,10};
        Weight w23 = new Weight(0.77, 1);
        Weight w31 = new Weight(0.9, 1);
        Weight w10 = new Weight(0.13, 1);
        Weight w04 = new Weight(2.9, 84);
        Weight w46 = new Weight(0.53, 1);
        Weight w65 = new Weight(0.42, 1);
        Weight w57 = new Weight(5.2, 170);
        Weight w78 = new Weight(2.78, 448);
        Weight w811 = new Weight(5, 12);
        Weight w119 = new Weight(1.23, 15);
        Weight w910 = new Weight(4, 26);

        G.addEdge(n2, n3, w23);
        G.addEdge(n3, n1, w31);
        G.addEdge(n1, n0, w10);
        G.addEdge(n0, n4, w04);
        G.addEdge(n4, n6, w46);
        G.addEdge(n6, n5, w65);
        G.addEdge(n5, n7, w57);
        G.addEdge(n7, n8, w78);
        G.addEdge(n8, n11, w811);
        G.addEdge(n11, n9, w119);
        G.addEdge(n9, n10, w910);
        return G;
    }

    /** Graph for Question3. */
    public static MyGraph<Node, Weight> buildQuestion3(int[] path) {
        MyGraph<Node, Weight> G;
        G = new MyGraph<>(path.length);
        Node n0 = new Node(0, 1, 0 - 238);
        Node n1 = new Node(1, 1.5, 70 -226);
        Node n2 = new Node(2, 2, 90 - 214);
        Node n3 = new Node(3, 3, 0 - 202);
        Node n4 = new Node(4, 5, 90 - 190);
        Node n5 = new Node(5, 2.5, 0 - 178);
        Node n6 = new Node(6, 5, 30 - 165);
        Node n7 = new Node(7, 2.5, 100 - 153);
        Node n8 = new Node(8, 3.5, 140 - 141);
        Node n9 = new Node(9, 2, 80 - 129);
        Node n10 = new Node(10, 2.5, 30 -117);
        Node n11 = new Node(11, 5, 115 - 105);

        // path = {2,3,1,0,4,6,5,7,8,11,9,10};
        Weight w23 = new Weight(0.77, 1);
        Weight w31 = new Weight(0.9, 1);
        Weight w10 = new Weight(0.13, 1);
        Weight w04 = new Weight(2.9, 84);
        Weight w46 = new Weight(0.53, 1);
        Weight w65 = new Weight(0.42, 1);
        Weight w57 = new Weight(5.2, 170);
        Weight w78 = new Weight(2.78, 448);
        Weight w811 = new Weight(5, 12);
        Weight w119 = new Weight(1.23, 15);
        Weight w910 = new Weight(4, 26);

        G.addEdge(n2, n3, w23);
        G.addEdge(n3, n1, w31);
        G.addEdge(n1, n0, w10);
        G.addEdge(n0, n4, w04);
        G.addEdge(n4, n6, w46);
        G.addEdge(n6, n5, w65);
        G.addEdge(n5, n7, w57);
        G.addEdge(n7, n8, w78);
        G.addEdge(n8, n11, w811);
        G.addEdge(n11, n9, w119);
        G.addEdge(n9, n10, w910);
        return G;
    }
}
