public class ArgsSum {
	/**  sums up the command line arguments, assuming they are numbers. */
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i++){
            try {
                sum = sum + Integer.parseInt(args[i]);
            }
			catch (NumberFormatException e) {
			    sum = 0;
			}			
		}
		System.out.println(sum);
	}
}

