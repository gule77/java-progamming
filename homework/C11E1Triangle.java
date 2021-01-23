import java.util.*;

class GeometricObject {
	private String color = "black";
	private boolean filled;
	private java.util.Date data;

	public GeometricObject() {
		data = new java.util.Date();
	}

	public GeometricObject(String color, boolean filled) {
		data = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return data;
	}
    
	public String toString() {
		return "created on " + data + "/ncolor: " + color + "and filled: " + filled;
	}
}

class Triangle extends GeometricObject{
	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;

	Triangle(){}
	
	Triangle(double side1,double side2, double side3) throws IllegalTriangleException{
		if(side1 <= 0 || side2 <= 0 || side3 <= 0) throw new IllegalTriangleException("Input must be positive");
		if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2) {
			throw new IllegalTriangleException("The sum of any two sides of a triangle must be greater than the third side");
		}

		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	double getSide1() {
		return this.side1;
	}

	double getSide2() {
		return this.side2;
	}

	double getSide3() {
		return this.side3;
	}

	double getArea() {
		double HalfP = getPerimeter() / 2;
		return Math.sqrt(HalfP * ((HalfP - side1) * (HalfP - side2) * (HalfP - side3)));
	}
	
	double getPerimeter(){
		return this.side1 + this.side2 + this.side3;
	}

	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

public class C11E1Triangle {

	public static void main(String[] args) throws IllegalTriangleException {
		System.out.println("This program can help you create triangles and fill them with colors");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int repeatInt = 1;
		while(repeatInt == 1){
			System.out.println("Enter first side: ");
			double side1 = input.nextDouble();
			System.out.println("Enter second side: ");
			double side2 = input.nextDouble();
			System.out.println("Enter third side: ");
			double side3 = input.nextDouble();
			System.out.println("Enter a color: ");
			String color = input.next();
			System.out.println("Do you want to color the triangle? (1 is yes, other numbers are no)");
			int fill = input.nextInt();
			boolean filled = true;
			if(fill==1) {
				filled = true;
			}else {
				filled = false;
			}
	
			try {
				Triangle triangle = new Triangle(side1, side2, side3);	
				triangle.setColor(color);
				triangle.setFilled(filled);
				System.out.println(triangle.toString());
				System.out.println("Area: " + triangle.getArea());
				System.out.println("Perimeter: " + triangle.getPerimeter());
				System.out.println("Color: " + triangle.getColor());
				System.out.println("Filled: " + (triangle.isFilled() ? "true" : "false"));
			}
			catch (IllegalTriangleException ex) {
				System.out.println("The sum of any two sides of a triangle must be greater than the third side");
			}

			System.out.print("Repeat program (enter 1 for yes or other number for no)?: ");
			repeatInt = input.nextInt();
		}
	}
}
