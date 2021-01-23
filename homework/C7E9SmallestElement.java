import java.util.Scanner;

public class C7E9SmallestElement {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		while(repeatInt == 1) {
			double[] numbers = new double[10];

			System.out.println("Enter ten numbers: ");
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = input.nextDouble();
			}

			System.out.println("The smallest element is: " + min(numbers));
			
			System.out.println("The index of smallest element is: " + indexOfSmallestElement(numbers));
			
			SelectionSort(numbers);
			System.out.println("The numbers after sorting: ");
			for (double l: numbers) {
				System.out.print(l + " ");
			}
			System.out.println("");
			
			System.out.println("Repeat program (enter 1 for yes or 0 for n)?: ");
	        repeatInt = input.nextInt();
		}

	}
	
	public static double min(double[] array) {
		double min = array[0];
		for (double j: array) {
			if (j < min)
				min = j;
		}
		return min;
	}
	
	public static int indexOfSmallestElement(double[] array) {
		if (array.length <= 1)
			return 0;
		
		double min = array[0];
		int minIndex = 0;
		for (int k = 1; k < array.length; k++) {
			if (array[k] < min) {
				min = array[k];
				minIndex = k;
			}
		}
		return minIndex;
	}
	
	public static void SelectionSort(double[] list) {
		for (int m = list.length - 1; m >= 0; m--) {
			double max = list[m];
			int maxIndex = m;
			for (int n = m - 1; n >= 0; n--) {
				if (max < list[n]) {
					max = list[n];
					maxIndex = n;
				}
			}
			if (maxIndex != m) {
				list[maxIndex] = list[m];
				list[m] = max;
			}
		}
	}
}
