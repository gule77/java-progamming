import java.util.Arrays;
import java.util.Scanner;

public class C5E16FactorsAndPrime {
	public static void main(String[] args){
		int j;
		int length = 0;
		int[] prime = new int[1];
		for(int i = 2;i <= 1000;i++){
			for(j = 2;j < i;j++) {
				if(i % j == 0) {
					break;
				}
			}
			if(i < 1000) {
				if(j >= i) {
					prime[length++] = i;
					prime = Arrays.copyOf(prime,prime.length+1);
				}
			}
			if(i == 1000) {
				if(j < i) {
					prime = Arrays.copyOf(prime,prime.length-1);
				}else {
					prime[length] = i;
				}
			}
		}

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		while(repeatInt == 1) {
			
//			System.out.println(prime.length);
			System.out.println("Prime numbers up to 1000 include:");
//			System.out.println(Arrays.toString(prime));
			for(int k = 0;k < length;k++) {
				for(int m = 0;m<11;m++) {
					System.out.printf(prime[k] + " ");
					k++;
				}
				System.out.printf(prime[k] + " ");
				System.out.println("");
			}
			System.out.println("");
			
			System.out.println("Enter an positive integer under 1000:");
			
			int num=input.nextInt();
			
			for (int l = 0; l < prime.length; l++) {
				if(num == 1) {
					System.out.println(num + " is not a prime number.");
					
					break;
				}
				if(prime[l] == num) {
					System.out.println(num + " is a prime number.");
					break;
				}
				if(prime[l] != num) {
					if(l == prime.length - 1){
						System.out.println(num + " is not a prime number.");
						System.out.print("Its factor is: ");
						int factor = 2;
						while (num / factor != 1) {
							if (num % factor  == 0) {
								System.out.print(factor + ", ");
								num /= factor; 
							}else {
								factor++;
							}
						}
						System.out.println(num + ".");
						break;
					}
				}
			}
			
			System.out.println("Repeat program (enter 1 for yes or 0 for n)?: ");
			repeatInt = input.nextInt();
		}
	}
}
