package com.github.kwesidev.restapp.utils;

public class ClientUtility {

	final static int ASCII_ZERO_CODE = 48;

	/**
	 * Function to validate South African ID Number,no decoding is needed for this just validation using luhn algo
	 * @param Id number a string containing the ID
	 * @return boolean
	 */
	public static boolean isValidSouthAfricanId(String idNumber) {
		// check if number is at least 13 characters
		if ((!idNumber.matches("^[0-9]{13}"))) {
			return false;
		}
		// Store Id numbers a Integer array
		int[] idNumberInts = new int[13];
		for (int i = 0; i < idNumber.length(); i++) {
			idNumberInts[i] = (int) idNumber.charAt(i) - ASCII_ZERO_CODE;
		}
        // Check if satisfies the Luhn Algorithm
		int sum, countEven, countOdd;
		countEven = 0;
		countOdd = 0;
		sum = 0;
		int[] oddNumbers = new int[10];
		int[] evenNumbers = new int[10];
		for (int i = idNumberInts.length - 1; i >= 0; i--) {
			if (i % 2 != 0) {
				oddNumbers[countOdd] = idNumberInts[i] * 2;
				countOdd++;
			} else {
				evenNumbers[countEven] = idNumberInts[i];
				countEven++;
			}
		}
		// If is > 9 add integers together
		for (int i = 0; i < countOdd; i++) {
			if (oddNumbers[i] > 9) {
				double value = oddNumbers[i] / 10.0;
				String[] sepValues = String.valueOf(value).toString().split("\\.");
				oddNumbers[i] = Integer.valueOf(sepValues[0]) + Integer.valueOf(sepValues[1]);
			}
			sum = sum  + oddNumbers[i];
		}
		// sum even numbers
		for (int i = 0 ; i < countEven; i++) {
			sum = sum + evenNumbers[i];
		}
		// check if is divisible by 10 
		if ((sum % 10) == 0) {
			return true;
		}
		
		return false;
	}
}
