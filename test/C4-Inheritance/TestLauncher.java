public class TestLauncher {
	/** Returns the larger number of x and y. */
	public static void main(String[] args) {
		A b0 = new B();
		System.out.println(b0.x);
		b0.m1();
		b0.m2();
		((B)b0).m2(61);
	}
}