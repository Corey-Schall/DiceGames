package com.techelevator;

public class Money {
	int gold = 0;
	int silver = 0;
	int copper = 0;
	
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void setSilver(int silver) {
		this.silver = silver;
	}
	
	public void setCopper(int copper) {
		this.copper = copper;
	}
	
	public int getGold() {
		return gold;
	}

	public int getSilver() {
		return silver;
	}

	public int getCopper() {
		return copper;
	}

	public void addMoney(int gold, int silver, int copper) {
		setGold(this.gold + gold);
		setSilver(this.silver + silver);
		setCopper(this.copper + copper);
	}
	
	public int getWinnings(int numberOfPredictions, int numberCorrect, int wager) {
		
		int winnings = 0;
		
		if(numberOfPredictions == 10) {
			if(numberCorrect == 10) {
				winnings = wager * 5000;
			}
			if(numberCorrect == 9) {
				winnings = wager * 2000;
			}
			if(numberCorrect == 8) {
				winnings = wager * 500;
			}
			if(numberCorrect == 7) {
				winnings = wager * 100;
			}
			if(numberCorrect == 6) {
				winnings = wager * 20;
			}
			if(numberCorrect == 5) {
				winnings = wager * 5;
			}
		}
		if(numberOfPredictions == 9) {
			if(numberCorrect == 9) {
				winnings = wager * 5000;
			}
			if(numberCorrect == 8) {
				winnings = wager * 2000;
			}
			if(numberCorrect == 7) {
				winnings = wager * 200;
			}
			if(numberCorrect == 6) {
				winnings = wager * 40;
			}
			if(numberCorrect == 5) {
				winnings = wager * 5;
			}
			if(numberCorrect == 4) {
				winnings = wager;
			}
		}
		if(numberOfPredictions == 8) {
			if(numberCorrect == 8) {
				winnings = wager * 5000;
			}
			if(numberCorrect == 7) {
				winnings = wager * 1500;
			}
			if(numberCorrect == 6) {
				winnings = wager * 100;
			}
			if(numberCorrect == 5) {
				winnings = wager * 10;
			}
			if(numberCorrect == 4) {
				winnings = wager * 2;
			}
		}
		if(numberOfPredictions == 7) {
			if(numberCorrect == 7) {
				winnings = wager * 2000;
			}
			if(numberCorrect == 6) {
				winnings = wager * 400;
			}
			if(numberCorrect == 5) {
				winnings = wager * 20;
			}
			if(numberCorrect == 4) {
				winnings = wager * 2;
			}
			if(numberCorrect == 3) {
				winnings = wager;
			}
		}
		if(numberOfPredictions == 6) {
			if(numberCorrect == 6) {
				winnings = wager * 800;
			}
			if(numberCorrect == 5) {
				winnings = wager * 50;
			}
			if(numberCorrect == 4) {
				winnings = wager * 4;
			}
			if(numberCorrect == 3) {
				winnings = wager * 2;
			}
		}
		if(numberOfPredictions == 5) {
			if(numberCorrect == 5) {
				winnings = wager * 200;
			}
			if(numberCorrect == 4) {
				winnings = wager * 10;
			}
			if(numberCorrect == 3) {
				winnings = wager * 2;
			}
		}
		if(numberOfPredictions == 4) {
			if(numberCorrect == 4) {
				winnings = wager * 60;
			}
			if(numberCorrect == 3) {
				winnings = wager * 5;
			}
			if(numberCorrect == 2) {
				winnings = wager * 2;
			}
		}
		if(numberOfPredictions == 3) {
			if(numberCorrect == 3) {
				winnings = wager * 30;
			}
			if(numberCorrect == 2) {
				winnings = wager * 2;
			}
		}
		if(numberOfPredictions == 2) {
			if(numberCorrect == 2) {
				winnings = wager * 5;
			}
			if(numberCorrect == 1) {
				winnings = wager;
			}
		}
		return winnings;
	}
	
	
}
