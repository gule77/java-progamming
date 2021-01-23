import java.util.Scanner;

public class C4E3estimateAreas {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		final double radius = 6371.01;
		
		//there are many cities have same name in a state, I choose 1st
		double AtlantaX = 33.7405800;
		double AtlantaY = -84.5545400;
		
		double OrlandoX = 28.4115300;
		double OrlandoY = -81.5250400;
		
		double SavannahX = 32.1672300;
		double SavannahY = -81.1998900;
		
		double CharlotteX = 35.2072400;
		double CharlotteY = -80.9567600;
		
		double distanceAO = radius * Math.acos( Math.sin(Math.toRadians(AtlantaX)) * Math.sin(Math.toRadians(OrlandoX)) +
				Math.cos(Math.toRadians(AtlantaX)) * Math.cos(Math.toRadians(OrlandoX)) * Math.cos(Math.toRadians(AtlantaY - OrlandoY)));
		System.out.println("The distance between Atlanta and Orlando is " + distanceAO + " km");
		
		double distanceSO = radius * Math.acos( Math.sin(Math.toRadians(SavannahX)) * Math.sin(Math.toRadians(OrlandoX)) +
				Math.cos(Math.toRadians(SavannahX)) * Math.cos(Math.toRadians(OrlandoX)) * Math.cos(Math.toRadians(SavannahY - OrlandoY)));
		System.out.println("The distance between Savannah and Orlando is " + distanceSO + " km");
		
		double distanceAS = radius * Math.acos( Math.sin(Math.toRadians(AtlantaX)) * Math.sin(Math.toRadians(SavannahX)) +
				Math.cos(Math.toRadians(AtlantaX)) * Math.cos(Math.toRadians(SavannahX)) * Math.cos(Math.toRadians(AtlantaY - SavannahY)));
		System.out.println("The distance between Atlanta and Savannah is " + distanceAS + " km");
		
		double distanceAC = radius * Math.acos( Math.sin(Math.toRadians(AtlantaX)) * Math.sin(Math.toRadians(CharlotteX)) +
				Math.cos(Math.toRadians(AtlantaX)) * Math.cos(Math.toRadians(CharlotteX)) * Math.cos(Math.toRadians(AtlantaY - CharlotteY)));
		System.out.println("The distance between Atlanta and Charlotte is " + distanceAC + " km");
		
		double distanceSC = radius * Math.acos( Math.sin(Math.toRadians(SavannahX)) * Math.sin(Math.toRadians(CharlotteX)) +
				Math.cos(Math.toRadians(SavannahX)) * Math.cos(Math.toRadians(CharlotteX)) * Math.cos(Math.toRadians(SavannahY - CharlotteY)));
		System.out.println("The distance between Savannah and Charlotte is " + distanceSC + " km");
		
		double s1 = (distanceAO + distanceSO + distanceAS) / 2;
		double area1 = Math.pow(s1 * (s1 - distanceAO) * (s1 - distanceSO) * (s1 - distanceAS), 0.5);
		System.out.println("The area of the triangle AOS is " + area1 + " square km");
		
		double s2 = (distanceAS + distanceAC + distanceSC) / 2;
		double area2 = Math.pow(s2 * (s2 - distanceAS) * (s2 - distanceAC) * (s2 - distanceSC), 0.5);
		System.out.println("The area of the triangle ACS is " + area2 + " square km");
		
		double estimatedArea = area1 + area2;
		System.out.println("The estimated area enclosed by these four cities is " + estimatedArea + " square km");
	}
}
