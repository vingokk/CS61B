package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Maze maze;
    private int sequence[] = new int[10000]; // represent the visited order of every vertex
    private int order = 0;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
    }

    @Override
    public void solve() {
        int startX = 1;
        int startY = 1;
        int s = maze.xyTo1D(startX , startY);
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        order += 1;
        sequence[v] = order;
        announce(); // drawing

        for (int w : maze.adj(v)) {
            if (marked[w] && (sequence[v] < sequence[w])) {
                edgeTo[w] = v;
                announce();
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                dfs(w);
            }
        }
    }
}

