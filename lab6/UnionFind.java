/** Weighted Quick Union Algorithm on Disjoint Sets. */
public class UnionFind implements DisjointSets {
	private int[] items;
	private int[] size;
	private int num;

	/** => Θ(N) */
    public UnionFind(int N) {
    	num = N;
    	items = new int[num];
    	size = new int[num];
    	for (int i = 0; i < num; i += 1) {
    		items[i] = i;
    		size[i] = 1;
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

		if (sizeOf(p) >= sizeOf(q)) {
			size[pRoot] = sizeOf(p) + sizeOf(q);
			items[qRoot] = items[pRoot];
		} else {
			size[qRoot] = sizeOf(p) + sizeOf(q);
			items[pRoot] = items[qRoot];
		}
	}

	/** Returns the size of the set v1 belongs to. */
	public int sizeOf(int p) {
		return size[findRoot(p)];
	}indRoot(q);

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
