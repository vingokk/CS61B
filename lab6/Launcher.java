import static java.lang.System.out;

public class Launcher {
	public static void main(String[] args) {
		// // Test QuickFindDS
		// DisjointSets ds = new QuickFindDS(10);
		// ds.connect(0, 1);
		// ds.connect(0, 2);
		// out.println(ds.isConnected(1, 2));

		// Test QuickUnoinDS
		UnionFind ds = new UnionFind(10);
		ds.connect(0, 1);
		out.println(ds.sizeOf(0));
		out.println(ds.sizeOf(1));
		ds.connect(0, 2);
		out.println(ds.sizeOf(0));
		out.println(ds.sizeOf(2));
		out.println(ds.sizeOf(1));
		ds.connect(2, 4);
		ds.connect(4, 5);
		out.println(ds.isConnected(1, 6));
	}
}