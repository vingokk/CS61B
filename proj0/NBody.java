public class NBody {
	/** Class that will actually run the simulation. */
	public static double readRadius(String filename) {
		In in = new In(filename);
		int numPlanets = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		String[] str = new String[100];
		Planet[] allPlanets = new Planet[5];
		int i = 0;
		int j = 0;
		
		while(!in.isEmpty()) {
			str[i] = in.readString();
			i++;
		}

		for(int k = 2; k < 27; k+=6){
			allPlanets[j] = new Planet(Double.parseDouble(str[k]),
			                           Double.parseDouble(str[k+1]),
								       Double.parseDouble(str[k+2]),
								       Double.parseDouble(str[k+3]),
								       Double.parseDouble(str[k+4]),
								       str[k+5]);
			j++;			
		}
        return allPlanets;
	}
    public static void main(String args){
		/* Collecting All Needed Input. */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);
		/* Drawing the Background. */
		/* public static String imageToDraw = "./images/starfield.jpg";
		StdDraw.setScale(2.50e+11, 2.50e+11);
		StdDraw.picture(0, 0, imageToDraw); */
	}	
}


// if(str.contains(".gif")) {
	// allPlanets[i] = imageName.substring(0, str.length()-4);
	// i++;
	// }

