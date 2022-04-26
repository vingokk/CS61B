public interface DisjointSets {
	/** Puts p and q into the same set. */
	void connect(int p, int q);

	/** Returns true if both p and q belong to the same set, false otherwise. */
	boolean isConnected(int p, int q);
}
