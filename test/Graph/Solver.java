/** Class that calculates the value of our objective function. */

import java.util.Stack;
public class Solver {
//    public int[] edgeTo;
//    public boolean[] marked;
//    private Node s; // source

    // Hyper parameter
    private MyGraph<Node, Weight> G;
    private int[] path; // Travelling route
    private double tActive;
    private double fHotel;
    private double fFood;
    private double F0; // restriction on Ftotal
    private double D0; // restriction on Dtotal

    public Solver(MyGraph<Node, Weight> g, int[] path, double[]parameter){
        this.G = g;
        this.path = path;
//        this.s = s;
//        edgeTo = new int[G.vertexNum()];
//        marked = new boolean[G.vertexNum()];
//        dfs(G, s);
        tActive = parameter[0];
        fHotel = parameter[1];
        fFood = parameter[2];
        F0 = parameter[3];
        D0 = parameter[4];
    }

    /** Conducts a depth first search of the map starting at the source. */
//    private void dfs(MyGraph<Node, Weight> G, Node v) {
//        marked[v.num] = true;
//        for (Node w : G.adj(v)) {
//            if (!marked[w.num]) {
//                edgeTo[w.num] = v.num;
//                dfs(G, w);
//            }
//        }
//    }

    /** Returns true if there is a path to v from s, false otherwise. */
//    public boolean hasPathTo(int v) {
//        return marked[v];
//    }

    /** Return the path to vertex v. */
//    public Iterable<Integer> pathTo(int v) {
//        if (!hasPathTo(v)) {return null;}
//        Stack<Integer> path = new Stack<Integer>();
//        for (int x = v; x != s.num; x = edgeTo[x])
//            path.push(x);
//        path.push(s.num);
//        return path;
//    }

    /** Calculates the object function MAXE. */
    public double calMAXE() {
        double fRatio = F0 / (calFtotal());
        double fDratio = D0 / (calDtotal());
        if (calFtotal() > F0 || calDtotal() > D0) {
            return -1;
        }
        System.out.println("calEfficiency: " + calEfficiency());
        System.out.println("calSatisfaction: " + calEfficiency());
        System.out.println("fRatio: " + fRatio);
        System.out.println("fDratio: " + fDratio);
        System.out.println("MAXE: " + calEfficiency() * calSatisfaction() * fRatio * fDratio);
        return calEfficiency() * calSatisfaction() * fRatio * fDratio;
    }

    /** Calculates the U-efficiency in the expression. */
    private double calEfficiency() {
        double sumTimeStay = 0;
        double sumTimeEdge = 0;
        for (int i = 0; i < path.length - 1; i += 1) {
            int s = path[i]; // index of source
            int t = path[i+1]; // index of target
            sumTimeStay += G.time[t];
            sumTimeEdge += G.timeEdge[s][t];
        }
        return sumTimeStay / (sumTimeStay + sumTimeEdge);
    }

    /** Calculates the U-satisfaction in the expression. */
    private double calSatisfaction() {
        double sumRank= 0;
        for (int i = 0; i < path.length - 1; i += 1) {
            int rank = path[i] + 1; // index of source
            sumRank += rank;
        }
        return path.length / sumRank;
    }

    /** Calculates the F-total in the expression. */
    private double calFtotal() {
        double sumMoneyStay = 0;
        double sumMoneyEdge = 0;
        for (int i = 0; i < path.length - 1; i += 1) {
            int s = path[i]; // index of source
            int t = path[i+1]; // index of target
            sumMoneyStay += G.money[t];
            sumMoneyEdge += G.moneyEdge[s][t];
        }
        return ((sumMoneyStay  + sumMoneyEdge) + fHotel * (calDtotal() - 1) + fFood * calDtotal());
    }

    /** Calculates the D-total in the expression. */
    private double calDtotal() {
        double sumTimeStay = 0;
        double sumTimeEdge = 0;
        for (int i = 0; i < path.length - 1; i += 1) {
            int s = path[i]; // index of source
            int t = path[i+1]; // index of target
            sumTimeStay += G.time[t];
            sumTimeEdge += G.timeEdge[s][t];
        }
        return (sumTimeEdge + sumTimeEdge) / tActive;
    }
}