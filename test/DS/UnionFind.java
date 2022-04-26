/** Weighted Quick Union Algorithm on Disjoint Sets. */
public class UnionFind implements DisjointSets {
	private Points[] items;
	private int num;

	/** => Θ(N) */
    public QuickUnionDS(int N) {
    	num = N;
    	items[0] = new int[num];
    	for (int i = 0; i < num; i += 1) {
    		items[i] = i;
    	}
    }

    public class Points {
    	private int x;
    	private int y;

    	public Points() {
    		x = 0;
    		y = 0;
    	}
    	public void Points.setX(int a) {
    		x = a;
    	}
    	public void Points.setY(int b) {
    		y = b;
    	}
    }

	// @Override
	/** Complexity => O(N) */
	public void connect(int p, int q) {
		if (p == q) {
			return;
		}
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		items[qRoot] = items[pRoot];
	}

	/** Returns the size of the set v1 belongs to. */
	public sizeOf(int p) {

	}

	// @Override
	/** Complexity => O(N) */
	public boolean isConnected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

	/** Returns the rootNodes of Node p. */
	private int findRoot(int p) {
		return find(p, items);
	}

	private int find(int p, int arr[]) {
		if (arr[p] == p) {
			return p;
		}
		return find(arr[p], arr);
	}
}
