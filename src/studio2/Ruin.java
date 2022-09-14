package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter starting amount: ");
		int startAmount = in.nextInt();
		int temp = startAmount;
		System.out.println("Enter win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter win limit: ");
		int winLimit = in.nextInt();
		int day=0;
		int wins = 0;
		int ruins = 0;
		int totalSimulations = 500;
		for (int i =0; i < totalSimulations; i++) {
			startAmount = temp;
			while (true) {
				if (Math.random() <= winChance) {
					startAmount += 1;
				}
				else {
					startAmount -= 1;
				}
				if (startAmount == 0) {
					ruins+=1;
					break;
				} else if (startAmount == winLimit) {
					wins+=1;
					break;
				}
				
			}
			System.out.println("Day: " + (i+1) + " Ruins: " + ruins + " Wins: " + wins);
		}
		double expected;
		double x;
		if (winChance == 0.5 ) {
			expected= 1.0 - ((double)temp/winLimit);
			
		}
		else {
			 x = (1-winChance)/winChance;
			 expected = (Math.pow(x, temp)-Math.pow(x, winLimit))/(1-Math.pow(x, winLimit));
		}
		System.out.println("Ruins: " + ruins + "\nWins: " + wins);
		System.out.println("Expected: "+ expected + "\nRuin rate from simulation: "+ (double)ruins/500);
		

	}
}


