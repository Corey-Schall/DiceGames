package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	
	Money balance = new Money();
	Scanner input = new Scanner(System.in);
	Random rando = new Random();
	
	public void toIntro() {
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to Century!");
		toMainMenu();
	}
	
	public void toMainMenu() {
		
		System.out.println("--------------------------------------------");
		System.out.println("Current balance:");
		System.out.print("   Gold: " + balance.getGold());
		System.out.print(" Silver: " + balance.getSilver());
		System.out.println(" Copper: " + balance.getCopper());
		System.out.println("--------------------------------------------");
		
		System.out.println("(1) Insert money");
		System.out.println("(2) View rules");
		System.out.println("(3) Play game");
		System.out.println("(4) Exit");
		System.out.println("--------------------------------------------");
		
		String choice = input.nextLine();
		
		if(choice.equals("1")) {
			toInsertMoney();
		}
		
		if(choice.equals("2")) {
			System.out.println("--------------------------------------------");
			System.out.println("Rules:");
			System.out.println("Each player bets a stake (the minimum is 5 cp) and chooses between two and 10 numbers that fall between one and 100.");
			System.out.println("Then, the dealer rolls the d10s 20 times to randomly generate 20 different numbers (rolling again if a duplicate is ever rolled). ");
			System.out.println("");
			System.out.println("Each player’s predictions are compared to the generated numbers.");
			System.out.println("A player receives a payout if some of their numbers match, depending on how many numbers the player predicted. ");
			System.out.println("Generally, the more numbers the player chooses, the more that need to match to receive any payout.");
			System.out.println("Payout:");
			System.out.println("                                 Numbers Predicted                      ");
			System.out.println("    |   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |  10   |");
			System.out.println("    | 1 |   x1  |       |       |       |       |       |       |       |       |");
			System.out.println("N C | 2 |   x5  |   x2  |   x2  |       |       |       |       |       |       |");
			System.out.println("u o | 3 |       |  x30  |   x5  |   x2  |   x2  |   x1  |       |       |       |");
			System.out.println("m r | 4 |       |       |  x60  |  x10  |   x4  |   x2  |   x2  |   x1  |       |");
			System.out.println("b r | 5 |       |       |       |  x200 |  x50  |  x20  |  x10  |   x5  |   x5  |");
			System.out.println("e e | 6 |       |       |       |       |  x800 |  x400 |  x100 |  x40  |  x20  |");
			System.out.println("r c | 7 |       |       |       |       |       | x2000 | x1500 |  x200 |  x100 |");
			System.out.println("s t | 8 |       |       |       |       |       |       | x5000 | x2000 |  x500 |");
			System.out.println("    | 9 |       |       |       |       |       |       |       | x5000 | x2000 |");
			System.out.println("    | 10|       |       |       |       |       |       |       |       | x5000 |");
		toMainMenu();
		}
		
		if(choice.equals("3")) {
			toPlayGame();
		}
		
		if(choice.equals("4")) {
			System.exit(0);
		}
		
	}
	
	public void toInsertMoney() {
	
		try {
			System.out.println("Enter an amount of money in gold, silver, and copper pieces.");
			System.out.print("Gold:   ");
			int addedGold = input.nextInt();
			System.out.print("Silver: ");
			int addedSilver = input.nextInt();
			System.out.print("Copper: ");
			int addedCopper = input.nextInt();
			input.nextLine();
			
			balance.addMoney(addedGold, addedSilver, addedCopper);
			
			
			
		}catch (Exception e) {
			System.out.println("Problem occourred.  No money Added.");
			toMainMenu();
		}
		toMainMenu();		
	}

	public void toPlayGame() {
		
		int numberOfPredictions = 0;
		int totalMoney = (balance.getGold() * 100) + (balance.getSilver() * 10) + balance.getCopper();
		
		if(totalMoney < 5) {
			System.out.println("Sorry, you don't have enough money to cover the minimum bet.");
			toMainMenu();
		}
		
		while(numberOfPredictions < 2  || numberOfPredictions > 10) {		
			System.out.print("How many numbers do you want to predict? (Between 2 - 10): ");
			numberOfPredictions = input.nextInt();
			input.nextLine();
		}
				
		int wager = 0;
		while (wager < 5 || wager > totalMoney) {
			System.out.print("How much would you like to wager (in copper pieces)?: ");
			wager = input.nextInt();
			input.nextLine();
			
			if(wager < 5) {
				System.out.println("\nThe minimum bet is 5 copper pieces.");
			}
			
			if(wager > totalMoney) {
				System.out.println("\nYou don't have enough money to cover that bet.");
			}
			
		}
		
		List <Integer> guesses = new ArrayList<Integer>();
		
		System.out.println("Enter your predictions (one at a time):");
		
		for(int i = 0; i < numberOfPredictions; i++) {
			System.out.print("Guess #" + (i + 1) + ": ");
			Integer guess = input.nextInt();
			input.nextLine();
			
			if(guess > 100 || guess < 1) {
				System.out.println("** You must guess a number between 1 and 100 **");
				i--;
			}
			
			if(guesses.contains(guess)) {
				System.out.println("** You must guess " + numberOfPredictions + " different numbers **");
				i--;
			}
			if(!guesses.contains(guess)) {
			guesses.add(guess);
			}
		}
		
		String guessPreview = "";
		for(int i = 0; i < numberOfPredictions; i++) {
			guessPreview += String.valueOf(guesses.get(i)) + ", ";
		}
		
		
		System.out.println("--------------------------------------------");
		guessPreview = guessPreview.substring(0, guessPreview.length()-2);
		System.out.println("Your guesses are " + guessPreview + " continue?");
		System.out.println("(1) Continue");
		System.out.println("(2) Back to Main Menu");
		System.out.println("--------------------------------------------");
		
		String choice = input.nextLine();
		
		if(choice.equals("2")) {
			toMainMenu();
		}
		
		if(!choice.equals("2") && !choice.equals("1")) {
			System.out.println("Something went wrong.  Returning to the Main Menu");
			toMainMenu();
		}
		
		List<Integer> rolledNumbers = new ArrayList<Integer>();
		Integer randomNum = 0;
		
		System.out.println("--------------------------------------------");
		System.out.println("The numbers rolled are:");
		
		for(int i = 0; i < 20; i++) {
			randomNum = rando.nextInt(100) + 1;
			if(rolledNumbers.contains(randomNum)) {
				i--;
			}
			if(!rolledNumbers.contains(randomNum)) {
				rolledNumbers.add(randomNum);
				System.out.print(randomNum + "   ");
				
			}
			
			if(i == 9) {
				System.out.print("\n");
			}	
			if(i == 19) {
				System.out.print("\n");
			}
		}
		
		int numberCorrect = 0;
		for(int i = 0; i < numberOfPredictions; i++) {
			if(rolledNumbers.contains(guesses.get(i))){
				numberCorrect++;
			}
		}
		
		int winnings = balance.getWinnings(numberOfPredictions, numberCorrect, wager);
		
		System.out.println("--------------------------------------------");
		System.out.println("You matched " + numberCorrect + " out of " + numberOfPredictions + ".");
		
		if(winnings > 0) {
			System.out.println("Congratulations!  You won " + winnings + " copper!");
		}else {
			System.out.println("Better luck next time!");
		}
		
		totalMoney = totalMoney - wager + winnings;
		
		int gold = 0;
		int silver = 0;
		int copper = 0;
		
		while(totalMoney >=100) {
			totalMoney -= 100;
			gold++;
		}
		while(totalMoney >=10) {
			totalMoney -= 10;
			silver++;
		}
		copper = totalMoney;
		
		balance.setGold(gold);
		balance.setSilver(silver);
		balance.setCopper(copper);
		
		toMainMenu();
	}
	
	
}
