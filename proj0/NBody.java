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
		int num = in.readInt();
		Planet[] allPlanets = new Planet[num];
		in.readDouble();
        for (int i = 0; i < num; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planet planet = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            allPlanets[i] = planet;
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
		int num = allPlanets.length;
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
		int waitTimeMilliseconds = 10;
		double[] xForces = new double[num];
		double[] yForces = new double[num];
		for(double count = 0; count < T; count += dt){
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
		}
		
		/*Printing the Universe*/
		StdOut.printf("%d\n", num);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < num; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
						  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
						  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}
	}	
}


// if(str.contains(".gif")) {
	// allPlanets[i] = imageName.substring(0, str.length()-4);
	// i++;
	// }

