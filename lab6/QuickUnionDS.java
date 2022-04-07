public class QuickUnionDS implements DisjointSets {
	private int[] items;
	private int num;

	/** => Θ(N) */
    public QuickUnionDS(int N) {
    	num = N;
    	items = new int[num];
    	for (int i = 0; i < num; i += 1) {
    		items[i] = i;
    	}
    }

	// @Override
	/** Complexity => O(N) */
	public void connect(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		items[qRoot] = items[pRoot];
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
