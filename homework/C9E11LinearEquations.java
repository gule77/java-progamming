import java.util.Scanner;

public class C9E11LinearEquations {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		while(repeatInt == 1) {
			
			System.out.println("The two endpoints for the first line segment are (x1, y1) and (x2, y2) ,"
					+ " and for the second line segment are (x3, y3) and (x4, y4).");
			
			System.out.print("Enter x1, y1: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			
			System.out.print("Enter x2, y2: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			
			System.out.print("Enter x3, y3: ");
			double x3 = input.nextDouble();
			double y3 = input.nextDouble();
			
			System.out.print("Enter x4, y4: ");
			double x4 = input.nextDouble();
			double y4 = input.nextDouble();
			
			double a = y1 - y2;
			double b = x2 - x1;
			double c = y3 - y4;
			double d = x4 - x3;
			double e = (y1 - y2) * x1 - (x1 - x2) * y1;
			double f = (y3 - y4) * x3 - (x3 - x4) * y3;
			
			LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
			
			if (equation.isSolvable()) {
				System.out.println("The intersection of the two lines is (" + equation.getX() + ", " + equation.getY() + ").");
			}else if ((a == 0 && b == 0) || (c == 0 && d == 0)) {
				System.out.println("You cannot set two identical endpoints for the line!");
			}else if ((a * d == b * c) && (b * f == d * e)) {
				System.out.println("The two lines are the same.");
			}else {
				System.out.println("The two lines are parallel.");
			}
		    
			System.out.print("Repeat program (enter 1 for yes or 0 for n)?: ");
			repeatInt = input.nextInt();
		}
	}
}

class LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	public LinearEquation(double A, double B, double C, double D, double E, double F) {
		a = A;
		b = B;
		c = C; 
		d = D;
		e = E;
		f = F; 
	}
	
	double getA() {
		return a;
	}

	double getB() {
		return b;
	}

	double getC() {
		return c;
	}

	double getD() {
		return d;
	}
	
	double getE() {
		return e;
	}
	
	double getF() {
		return f;
	}
	
	boolean isSolvable() {
		if (a * d - b * c != 0) {
			return true;
		}
		return false;

	}
	
	double getX() {
		double x = (e * d - b * f) / (a * d - b * c);
		return x; 
	}

	double getY() {
		double y = (a * f - e * c) / (a * d - b * c);
		return y;
	}
}