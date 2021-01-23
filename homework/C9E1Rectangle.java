import java.util.InputMismatchException;
import java.util.Scanner;

public class C9E1Rectangle {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		int repeatInt = 1;
		while (repeatInt == 1){
			System.out.println("Please enter the width and height of the rectangle in turn, "
					+ "the program will calculate its area and perimeter:");
			
			boolean continueInput = true;
			double width1 = 0;
			double heigh1 = 0;
			do {
				try {
					Scanner input = new Scanner(System.in);
					
					width1 = input.nextDouble();
					heigh1 = input.nextDouble();
					
					continueInput = false;
				}catch (InputMismatchException e){
					e.getStackTrace();
					System.out.println("Your input is wrong. Please check and re-enter the width and height of the rectangle:");
					
					continueInput = true;
				}
			} while (continueInput);
			try{
				Rectangle rectangle = new Rectangle();
				rectangle.set(width1,heigh1);
				System.out.println("Width: " + rectangle.width);
				System.out.println("Height: " + rectangle.height);
				System.out.println("Area: " + rectangle.getArea());
				System.out.println("Perimeter: " + rectangle.getPerimeter());
			}catch (Exception e){
				e.printStackTrace();
			}
			
			System.out.println("Repeat program (enter 1 for yes or 0 for n)?: ");
			Scanner input = new Scanner(System.in);
			repeatInt = input.nextInt();
		}
	}
}
