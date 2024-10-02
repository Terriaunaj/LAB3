
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	//Constructors
	public Triangle() {
		
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		
		if(isTriangle(sideA,sideB,sideC) == true) {
			
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
		else {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle(double[] sides) {
		
		if(isTriangle(sides) == true) {
			
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
		
		else {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle(Triangle triangle) {
		
		if(triangle != null) {
			this.sideA = triangle.sideA;
			this.sideB = triangle.sideB;
			this.sideC = triangle.sideC;
		}
		else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	//Getters
	public double getSideA() {
		return this.sideA;
	}
	
	public double getSideB() {
		return this.sideB;
	}
	
	public double getSideC() {
		return this.sideC;
	}
	
	public double[] getSides() {
		return new double[] {sideA,sideB,sideC};
	}
	
	//Angle Getters
	public double getAngleA() {
		
		return lawOfCosines(sideB,sideC,sideA);
	}
	
	public double getAngleB() {
		
		return lawOfCosines(sideC,sideA,sideB);
	}
	
	public double getAngleC() {
		
		return lawOfCosines(sideA,sideB,sideC);
	}
	
	public double[] getAngles() {
		return new double[] {getAngleA(),getAngleB(),getAngleC()};
	}
	
	//Setters
	public boolean setSideA(double sideA) {
		
		if(isTriangle(sideA, sideB,sideC) == true) {
			this.sideA = sideA;
			return true;			
		}
		
		else {
			return false;
		}
	}
	
	public boolean setSideB(double sideB) {
		
		if(isTriangle(sideA, sideB,sideC) == true) {
			this.sideB = sideB;
			return true;			
		}
		
		else {
			return false;
		}
	}
	
	public boolean setSideC(double sideC) {
		
		if(isTriangle(sideA, sideB,sideC) == true) {
			this.sideC = sideC;
			return true;			
		}
		
		else {
			
			return false;
		}
	}
	
	public boolean setSides(double[] sides) {
		
		if(isTriangle(sides) == true) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];			
			return true;
			
		}
		
		else {
			
			return false;
		}
	}
	
	//Helper Methods
	public static boolean isTriangle(double a, double b, double c) {
		
		if((a > 0 && b > 0 && c > 0) && (a + b > c && b + c > a && c + a > b)) {
			return true;			
		}
		else {
			return false;
		}
	}
	
	public static boolean isTriangle(double[] sides) {
		
		if((sides != null) && (sides.length == 3) && (sides[0] > 0 && sides[1] > 0 && sides[2] > 0) && (sides[0]+sides[1]>sides[2] && sides[1]+sides[2]>sides[0] && sides[2]+sides[0] > sides[1])) {
			return true;
		}
		else {
			
			return false;
		}
		
	}
	
	public static double lawOfCosines(double a, double b, double c) {
		
		return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
	}
	
	//String Representation
	public String toString() {
		
		String string = String.format("%s(%.4f, %.4f, %.4f)",POLYGONSHAPE , sideA , sideB ,sideC);
		return string;
	}
}
