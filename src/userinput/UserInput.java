package userinput;

import java.util.Scanner;

public class UserInput {
	
	public static String getString() {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		return s;
	}
	
	public static char getChar() {
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() {
		String s = getString();
		return Integer.parseInt(s);
	}
	
	public static double getDouble() {
		String s = getString();
		return Double.parseDouble(s);
	}
	
	public static String getString(int min, int max) {
		String str = getString();
		
		while (str.length() < min || str.length() > max) {
			if (str.length() < min) {
				System.err.println("ERROR: Not enough characters. Try again.");
			} else if (str.length() > max) {
				System.err.println("ERROR: Too many characters. Try again.");
			}
			str = getString();
		}
		
		return str;
	}
	
	public static char getChar(char min, char max) {
		String c = getString().toUpperCase().charAt(0);
		
		while (c < min || c > max) {
			System.err.println("ERROR: Out of char range. Try again.");
			c = getString().toUpperCase().charAt(0);
		}
		
		return c;
	}
	
	public static int getInt(int min, int max) {
		int i = getInt();
		
		while (i < min || i > max) {
			if (i < min) {
				System.err.println("ERROR: Integer too low. Try again.");
			} else if (i > max) {
				System.err.println("ERROR: Integer too high. Try again.");
			}
			i = getInt();
		}
		
		return i;
	}
	
	public static double getDouble(double min, double max) {
		double d = getDouble();
		
		while (d < min || d > max) {
			System.err.println("ERROR: Out of double range. Try again.");
			d = getDouble();
		}
		
		return d;
	}
	
}
