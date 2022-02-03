public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
				  xxPos = xP;
				  yyPos = yP;
				  xxVel = xV;
				  yyVel = yV;
				  mass = m;
				  imgFileName = img;
			  }
	public Planet(Planet p) {
				  this.xxPos = p.xxPos;
				  this.yyPos = p.yyPos;
				  this.xxVel = p.xxVel;
				  this.yyVel = p.yyVel;
				  this.mass = p.mass;
				  this.imgFileName = p.imgFileName;		
	}
	public double calcDistance(Planet a) {
		/* Returns the distance between two Planets. */
		double dx = a.xxPos - this.xxPos;
		double dy = a.yyPos - this.yyPos;
		double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		return r;
	}
	public double calcForceExertedBy(Planet a) {
		/* Returns the force exerted on this planet by the given planet*/
		double r = this.calcDistance(a);
		double F = ((6.67e-11) * this.mass * a.mass) / Math.pow(r, 2);
		return F;
	}
	public double calcForceExertedByX(Planet a) {
		/* Returns the force exerted in the X direction. */
		double F = this.calcForceExertedBy(a);
		double r = this.calcDistance(a);
		double dx = a.xxPos - this.xxPos;
		double Fx = F * dx / r;
		return Fx;
	}
	public double calcForceExertedByY(Planet a) {
		/*  Returns the force exerted in the Y direction.*/
		double F = this.calcForceExertedBy(a);
		double r = this.calcDistance(a);
		double dy = a.yyPos - this.yyPos;
		double Fy = F * dy / r;
		return Fy;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		/*  Returns the net X force exerted by all planets*/
		double sum = 0;
		for(Planet P : allPlanets) {
			if(this.equals(P)) {
				continue;
			}
			sum += this.calcForceExertedByX(P);
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		/*  Returns the net Y force exerted by all planets*/
		double sum = 0;
		for(Planet P : allPlanets) {
			if(this.equals(P)) {
				continue;
			}
			sum += this.calcForceExertedByY(P);
		}
		return sum;
	}
	public void update(double dt, double Fx, double Fy) {
		/* Updates the planet’s position and velocity instance variables. */
		double ax = Fx / this.mass; // acceleration in the X direction.
		double ay = Fy / this.mass; // acceleration in the Y direction.
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}
}