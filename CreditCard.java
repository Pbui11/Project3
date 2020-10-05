/*
 * Class: CMSC201 
 * Instructor: 
 * Description: write a program that prompts the user to enter a credit card number as a long integer. Display whether the number is valid or invalid. 
 * Due: 10/04/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Phuc Bui
*/

import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Create a Scanner

		System.out.print("Enter a credit card number as a long integer: ");

		long num = input.nextLong();
		
		displayResult(num);	
		
		input.close();
	}
	
 /** Return true if the card number is valid */
	public static boolean isValid(long num) {
			boolean valid =
						(getSize(num) >= 13 && getSize(num) <= 16) &&
						(prefixMatched(num, 4) || prefixMatched(num, 5) ||
						prefixMatched(num, 37) || prefixMatched(num, 6)) &&
						((sumOfDoubleEvenPlace(num) + sumOfOddPlace(num)) % 10 == 0);

					return valid;
		  }
		 
		  /** Get the result from Step 2 */
		  public static int sumOfDoubleEvenPlace(long num) {
		  int sum = 0;
			String credit = num + "";
			for (int i = getSize(num) - 2; i >= 0; i -= 2) {
				sum += getDigit(Integer.parseInt(credit.charAt(i) + "") * 2);
			}
			return sum;
}
		  
		  
		  /** Return this number if it is a single digit, otherwise, 
		   * return the sum of the two digits */
		  public static int getDigit(int num) {
				if (num < 9)
					return num;
				else
					return num / 10 + num % 10;
		  }
		  
		  /** Return sum of odd-place digits in number */
		  public static int sumOfOddPlace(long num) {
				int sum = 0;
				String credit = num + "";
				for (int i = getSize(num) - 1; i >= 0; i -= 2) {
					sum += Integer.parseInt(credit.charAt(i) + "");
				}
				return sum;
			}
		  /** Return true if the digit d is a prefix for number */
		  public static boolean prefixMatched(long num, int d){
				return getPrefix(num, getSize(d)) == d;
			}
		 
		 
		 /** Return the number of digits in d */
		  public static int getSize(long d) {
				String num = d + "";
				return num.length();
			}
		 
		  /** Return the first k number of digits from number. If the
		   * number of digits in number is less than k, return number. */
		 
		 public static long getPrefix(long num, int k){
				if (getSize(num) > k)  {
					String credit = num + " ";
					return  Long.parseLong(credit.substring(0, k));
				}
				return num;
			}
		 
		/** input credit card’s number from keyboard
		Return this credit Card’s number
		*/
		  public static long inputData() {
		  Scanner input = new Scanner (System.in);
			long num = input.nextLong();
			input.close();
			return num;
		  }
		/**
		  Display result using a method println()
		*/
		 public static void displayResult(long num) {
		  System.out.println(num+" is "+(isValid(num)? "valid":"invalid"));
		
	}

}


