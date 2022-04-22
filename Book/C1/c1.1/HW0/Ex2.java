public class Ex2 {
	/** Returns the the maximum value of an int array.*/
	public static int LargerNumber(int a, int b) {
		if(a > b){
			return a;
		}
		return b;
	}
	public static int max(int[] m) {
		int TempMax;
		TempMax = LargerNumber(m[0], m[1]);
		for(int i = 2; i < m.length; i++) {
			TempMax = LargerNumber(m[i], TempMax);
		}
		return TempMax;
	}
	public static void main(String[] args){
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
}

/*
int[] a = new int[3];
a[0] = 1;
a[1] = 2;
a[2] = 2

int[] a = new int[]{4, 7, 10];
System.out.println(a.length);
*/