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
    public static void main(String[] args){
		/* Collects All Needed Input. */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);
		
		/* Draws the Background. */
	    String imageToDraw = "./images/starfield.jpg";
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		for(Planet P : allPlanets) {
			P.draw();
		}
		
		/* Creats an Animation. */
		StdDraw.enableDoubleBuffering();
		double count = 0;
		int waitTimeMilliseconds = 10;
		double[] xForces = new double[5];
		double[] yForces = new double[5];
		while(count < T){
			int i = 0;
			for(Planet P : allPlanets) {
				/* Calculates. */
				xForces[i] = P.calcNetForceExertedByX(allPlanets);
				yForces[i] = P.calcNetForceExertedByY(allPlanets);
				allPlanets[i].update(dt, xForces[i], yForces[i]);
				i++;
		    }
			
			/* Draws. */
			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);
		    for(Planet P : allPlanets) {
			    P.draw();
		    }
			StdDraw.show();
			StdDraw.pause(waitTimeMilliseconds);
			count += dt;
		}
	}	
}


// if(str.contains(".gif")) {
	// allPlanets[i] = imageName.substring(0, str.length()-4);
	// i++;
	// }

