//=======================================
// High and Low - by Nico Poblete
// Copyright 2012 Nico Poblete/Ocampo's Games Indep.
// ** This produces the high-low game, which has
//    the user guess if the second number is 
//    higher or lower than the first number.
//=======================================

package game;

import java.util.*;

import userinput.UserInput;

public class HighLow {
	
	private int firstNum, secondNum, scoreValue, score, timesPlayed;
	
	public HighLow() {
		firstNum = 0;
		secondNum = 0;
		scoreValue = 0;
		score = 0;
		timesPlayed = 0;
		
		setupNumbers();
	}
	
	public void setFirstNum(int n) {
		firstNum = n;
	}
	
	public void setSecondNum(int n) {
		secondNum = n;
	}
	
	public void setScoreValue(int s) {
		scoreValue = s;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void setTimesPlayed(int t) {
		timesPlayed = t;
	}
	
	public int getFirstNum() {
		return firstNum;
	}
	
	public int getSecondNum() {
		return secondNum;
	}
	
	public int getScoreValue() {
		return scoreValue;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTimesPlayed() {
		return timesPlayed;
	}
	
	private void setupNumbers() {
		System.out.println("Thinking up numbers right now...\n");
		Random rand = new Random();
		
		setFirstNum(rand.nextInt(52));
		setSecondNum(rand.nextInt(52));
		
		if ((getFirstNum() == 0 || getSecondNum() == 0) || 
				(getFirstNum() == 0 && getSecondNum() == 0)) {
			setFirstNum(getFirstNum() + 1);
			setSecondNum(getSecondNum() + 1);
		}
		
		if (getScoreValue() == 0) {
			setScoreValue(getScoreValue() + 1);
		}
		
		System.out.println("Done!\n");
		ask();
	}
	
	public void showSecondNum() {
		System.out.println("SECOND NUMBER: " + getSecondNum());
	}
	
	
	public void ask() {
		String askStr;
		char askChar;
		
		System.out.println("SCORE: "+ getScore());
		System.out.println("FIRST NUMBER: " + getFirstNum());
		System.out.print("Is the second number higher or lower (H or L)? ");
		askStr = UserInput.getString().toUpperCase();
		
		askChar = askStr.charAt(0); // Check the first character in ask string.
		
		check(askChar);
	}
	
	public void askDoubleDown() {
		String askDoubDownStr;
		char askDoubDownChar;
		
		if (getTimesPlayed() < 10) {
			do {
				System.out.print("You wanna double down? Raise the stakes a little (Y or N)? ");
				askDoubDownStr = UserInput.getString().toUpperCase();
				askDoubDownChar = askDoubDownStr.charAt(0);
				
				switch(askDoubDownChar) {
				case 'Y':
					// Double the score value and set up the numbers.
					setScoreValue(getScoreValue() * 2);
					setTimesPlayed(getTimesPlayed() + 1);
					setupNumbers();
					break;
				case 'N':
					// Call a game over and display score.
					gameOver();
					break;
				default:
					System.out.println("I'll want an answer any day now!\n");
					continue;
				}
			} while (askDoubDownChar != 'Y' || askDoubDownChar != 'N');
		} else {
			System.out.println("Bye bye! Overstayed your welcome!\n");
			gameOver();
		}
	}
	
	public void check(char askChar) {
		// Check the conditions: H for higher, L for lower
		switch (askChar) {
		case 'H':
			decisionIsHigher();
			break;
		case 'L':
			decisionIsLower();
			break;
		default:
			System.out.println("Not a good letter to start with.\n");
			ask(); // Ask again for a decision
			break;
		}
	}
	
	private void decisionIsHigher() {
		if (getSecondNum() > getFirstNum()) {
			// Increment score and ask to double down.
			setScore(getScoreValue());
			showSecondNum();
			System.out.println("Yes!!" + "\n" + "SCORE: " + getScore());
			askDoubleDown();
		} else if (getSecondNum() < getFirstNum()) {
			// GAME OVER!
			showSecondNum();
			gameOver();
		} else if (getSecondNum() == getFirstNum()) {
			// Set up numbers again!
			showSecondNum();
			System.out.println("Whoops! It's a draw! Have to get new numbers!\n");
			setupNumbers();
		}
	}
	
	private void decisionIsLower() {
		if (getSecondNum() > getFirstNum()) {
			// GAME OVER!
			showSecondNum();
			gameOver();
		} else if (getSecondNum() < getFirstNum()) {
			// Increment score and ask to double down.
			setScore(getScoreValue());
			showSecondNum();
			System.out.println("Yes!!" + "\n" + "SCORE: " + getScore());
			askDoubleDown();
		} else if (getSecondNum() == getFirstNum()) {
			// Set up numbers again!
			showSecondNum();
			System.out.println("Whoops! It's a draw! Have to get new numbers!\n");
			setupNumbers();
		}
	}
	
	public void gameOver() {
		String decStr;
		char decChar;
		
		// The game is over! Prompt the score.
		System.out.println("======GAME OVER MAN!!!!======\n");
		System.out.println("SCORE: " + getScore() + "\n");
		
		// Ask if they want to play again?
		System.out.print("Want to play again (Y or any key to exit)? ");
		decStr = UserInput.getString().toUpperCase();
		decChar = decStr.charAt(0);
		
		switch (decChar) {
		case 'Y':
			// Reset score and scoreValue.
			setScore(0);
			setScoreValue(0);
			setupNumbers();
			break;
		case 'N':
			System.exit(0);
			break;
		default:
			System.exit(0);
			break;
		}
	}
	
	public static void main(String[] args) {
		
		HighLow h = new HighLow();
		
	}
}
