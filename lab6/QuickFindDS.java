public class QuickFindDS implements DisjointSets {
	private int[] items;
	private int num;

	/** => Θ(N) */
    public QuickFindDS(int n) {
    	num = n;
    	items = new int[num];
    	for (int i = 0; i < num; i += 1) {
    		items[i] = i;
    	}
    }

	// @Override
	/** Complexity => O(N) */
	public void connect(int p, int q) {
		for (int i = 0; i < num; i += 1) {
    		if (items[i] == items[q]) {
    			items[i] = items[p];
    		}
    	}
	}

	// @Override
	/** Complexity => Θ(1) */
	public boolean isConnected(int p, int q) {
		return items[p] == items[q];
	}
}
