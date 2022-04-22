public class TestLauncher {
	public static OurComparable max(OurComparable[] items) {
    int maxDex = 0;
    for (int i = 0; i < items.length; i += 1) {
        int cmp = items[i].compareTo(items[maxDex]);
        if (cmp > 0) {
            maxDex = i;
        }
    }
    return items[maxDex];
}

	public static void main(String[] args) {
		Dog d1 = new Dog("s", 5);
		Dog d2 = new Dog("s222", 6);
		Dog[] d3 = {d1, d2};
        System.out.println(((Dog) max(d3)).name);
	}
}