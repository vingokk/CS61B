public class Dog implements OurComparable {
	public String name;
    private int size;
	
	public Dog(String n, int s) {
        name = n;
        size = s;
    }
	
	/** Compares the given object to itself. */
	@Override
    public int compareTo(Object o) {
		Dog uddaDog = (Dog) o;
		return this.size - uddaDog.size;
    }
	
	public void bark() {
        System.out.println(name + " says: bark");
	}
}
    