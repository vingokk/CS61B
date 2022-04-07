package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[] sites;
    private int size; // the number of whole item
    private int len; // the number of colum
    private int numOpen; // the number of the sites which is open
    private WeightedQuickUnionUF set;

    /** Creates N-by-N grid, with all sites initially blocked. */
    public Percolation(int N) {
        // R(N) ->  θ(N ^ 2)
        if (N < 0) {
            throw new IllegalArgumentException("the argument to Percolation is less than 0");
        }
        size = N * N;
        len = N;
        numOpen = 0;
        sites = new int[size + 2] ; // N * N grid + top site + bottom site
        set = new WeightedQuickUnionUF(size + 2);

        //Initialize
        for (int i = 0; i < size; i += 1) {
            sites[i] = 0; // 0 represents blocked, 1 represents open
        }
        sites[size] = 1; // top site
        sites[size + 1] = 1; // bottom site
    }

    /** Opens the site (row, col) if it is not open already. */
    public void open(int row, int col) {
        // R(N) ->  θ(logN)
        int index = xyTo1D(row, col);
        sites[index] = 1;
        numOpen += 1;
        siteUnion(index);
    }
    private void siteUnion(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("the argument to open is beyond scope");
        }
        // right bound
        if((index + 1) % len != 0 && sites[index + 1] == 1) {
            set.union(index, index + 1);
        }

        //left bound
        if(index % len != 0 && sites[index - 1] == 1) {
            set.union(index, index - 1);
        }

        // upper bound
        if((index - len) >= 0 && sites[index - len] == 1) {
            set.union(index, index - len);
        }

        // lower bound
        if((index + len) < size && sites[index + len] == 1) {
            set.union(index, index + len);
        }

        // top
        if((index - len) < 0) {
            set.union(index, size);
        }

        // bottom
        if ((index + len >= size)) {
            set.union(index, size + 1);
        }
    }
    /** Returns the 1-dimensional position of coordinate(x, y). */
    private int xyTo1D(int row, int col) {
        return row * len + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = xyTo1D(row, col);
        return sites[index] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        // R(N) ->  θ(logN)
        int index = xyTo1D(row, col);

        // returns true if the item is connected the topRow, false otherwise.
        return set.connected(index, size);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }
    // does the system percolate?
    public boolean percolates() {
        // R(N) ->  θ(logN)
        return set.connected(size, size + 1);
    }
    // use for unit testing (not required)
    public static void main(String[] args) {
        Percolation p = new Percolation(6);

        p.open(0, 2); //2
        p.open(1, 2); //7
        p.open(2, 4); //14
        p.open(2, 2); //12
        p.open(2, 3); //13
        p.open(3, 4); //19
        p.open(4, 4); //24

        System.out.println(p.set.connected(2, 14));
        System.out.println(p.isFull(2, 4));
        System.out.println(p.percolates());
        System.out.println(p.numOpen);
    }
}
