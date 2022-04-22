public class Ex4 {
  public static void windowPosSum(int[] a, int n) {
	  int sum = 0;
	  int num = 0; 
	  for(int i = 0; i < a.length; i++){
		  sum = 0;
		  num = 0;
		  if(a[i] < 0){
			  continue;
		  }
		  for(int j = i; num < n + 1; j++){
			  if(j == a.length){
				  break;
			  }
			  sum = sum + a[j];
			  num++;
		  }
		  a[i] = sum;
	  }
  }

  public static void main(String[] args) {
    int[] a = {1, -1, -1, 10, 5, -1};
    int n = 2;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}