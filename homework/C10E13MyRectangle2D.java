import java.util.Scanner;

class MyRectangle2D{
	private double x;
	private double y;
	private double width;
	private double height;
	
	public MyRectangle2D() throws Exception{
		this(0,0,1,1);
	}
	
	public MyRectangle2D(double x,double y, double width,double height) throws Exception {
		if(width <= 0 || height <= 0) throw new Exception();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setWidth(double width) throws Exception {
		if(width <= 0) throw new Exception();
		this.width = width;
	}
	
	public void setHeight(double height) throws Exception {
		if(height <= 0) throw new Exception();
		this.height = height;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getArea(){
		return height * width;
	}
	
	public double getPerimeter(){
		return 2 * (width + height);
	}
	
	private double getDistance(double p1, double p2) {
		return Math.sqrt(Math.pow(p2 - p1, 2));
	}
	
	public boolean contains(double x,double y){
		if(getDistance(this.x, x) <= width / 2  &&  getDistance(this.y, y) <= height / 2) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean inclusion(MyRectangle2D r){
		double leftX = r.x - r.width / 2;
		double downY = r.y - r.height / 2;
		double rightX = r.x + r.width / 2;
		double upY = r.y + r.height / 2;
		if(contains(leftX,downY) && contains(rightX,upY)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean overlap(MyRectangle2D r){
		double leftX = r.x - r.width / 2;
		double downY = r.y - r.height / 2;
		double rightX = r.x + r.width / 2;
		double upY = r.y + r.height / 2;
		if(!inclusion(r) && (contains(leftX,downY) || contains(leftX,upY) || contains(rightX,downY) || contains(rightX,upY))) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean abutment(MyRectangle2D r) {
		boolean right = (x + width / 2) == (r.x - r.width / 2) || (x + width / 2) == (r.x + r.width / 2);
		boolean left = (x - width / 2) == (r.x - r.width /2) || (x - width / 2) == (r.x + r.width /2);
		boolean up = (y + height / 2) == (r.y - r.height / 2) || (y + height / 2) == (r.y + r.height / 2);
		boolean down = (y - height / 2) == (r.y - r.height / 2) || (y - height / 2) == (r.y + r.height / 2);
		if(right || left || up || down) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean distinctions(MyRectangle2D r) {
		if(!overlap(r) && !abutment(r)) {
			return true;
		}else {
			return false;
		}
	}
}

public class C10E13MyRectangle2D {
	private static boolean outer = true;
	private static boolean middle = true;
	private static boolean inner = true;
	
	public static void main(String []args) throws Exception {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		while(repeatInt == 1){
			System.out.println("This is a program to detect the relationship between the basic rectangle and the test rectangle. "
					+ "\nPlease input the numbers as prompted (all the inputs are positive).");
			middle=true;
			inner=true;
			while(outer) {

				while(middle){
					System.out.println("\nStart setting basic rectangle!");
					System.out.print("Enter the X of the center of rectangle: ");
					double x = input.nextDouble();
					System.out.print("Enter the Y of the center of rectangle: ");
					double y = input.nextDouble();
					System.out.print("Enter the width of the rectangle: ");
					double width = input.nextDouble();
					System.out.print("Enter the height of the rectangle: ");
					double height = input.nextDouble();
					MyRectangle2D rectangle;
					try{
						rectangle = new MyRectangle2D(x,y,width,height);
						System.out.println("The area of the base rectangle is: " + rectangle.getArea());
						System.out.println("The perimeter of the base rectangle is: " + rectangle.getPerimeter());
					}catch (Exception e){
						System.out.println("\nInvalid input, please try again.");
						break;
					}
					

						while(inner){
							int repeat = -1;
							
							System.out.println("\nStart setting test rectangle!");
							System.out.print("Enter the X of the center of rectangle: ");
							double x2 = input.nextDouble();
							System.out.print("Enter the Y of the center of rectangle: ");
							double y2 = input.nextDouble();
							System.out.print("Enter the width of the rectangle: ");
							double width2 = input.nextDouble();
							System.out.print("Enter the height of the rectangle: ");
							double height2 = input.nextDouble();
							
							try{
								MyRectangle2D test = new MyRectangle2D(x2,y2,width2,height2);
								
								System.out.print("\nIs base rectangle and test rectangle inclusion: ");
								if(rectangle.inclusion(test)) {
									System.out.println("Yes");
								}else {
									System.out.println("No");
								}
								
								System.out.print("Is base rectangle and test rectangle overlap: ");
								if(rectangle.overlap(test)) {
									System.out.println("Yes");
								}else {
									System.out.println("No");
								}
								
								System.out.print("Is base rectangle and test rectangle abutment: ");
								if(rectangle.abutment(test)) {
									System.out.println("Yes");
								}else {
									System.out.println("No");
								}
								
								System.out.print("Is base rectangle and test rectangle distinctions: ");
								if(rectangle.distinctions(test)) {
									System.out.println("Yes");
								}else {
									System.out.println("No");
								}
								
								System.out.println("if you want to enter a new test rectangle, enter 1; "
										+ "enter other positive number or 0 to exit");
								repeat = input.nextInt();
							}catch (Exception e) {
								System.out.println("\nInvalid input, please try again.");
							}
							
							if(repeat == 1) {
								inner=true;
							}else if(repeat < 0){
							
							}else {
								inner=false;
								middle=false;
							}
						}
				}
				break;
			}
			System.out.print("Repeat program (enter 1 for yes or other number for no)?: ");
			repeatInt = input.nextInt();
		}
	}
}
