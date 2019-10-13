package org.redquark.problems.miscellaneous;

/**
 * This class takes two arrays of numerators and denominators of fractions and
 * add those fractions
 * 
 * @author Anirudh Sharma
 *
 */
public class AddFractions {

	public static void main(String[] args) {

		// Array containing numerators of all the fractions
		int[] numerators = { -3, 5, 7 };
		// Array containing denominators of all the fractions
		int[] denominators = { 4, 9, 12 };

		// Initialize intermediate numerators and denominators
		int intermediateNumerator = 0;
		int intermediateDenominator = 1;

		// Get the product of all the denominators
		for (int i = 0; i < denominators.length; i++) {
			intermediateDenominator *= denominators[i];
		}

		// Get the sum of all the numerators multiplied by the intermediate denominators
		// and divided by its own denominator
		for (int i = 0; i < numerators.length; i++) {
			intermediateNumerator += intermediateDenominator * numerators[i] / denominators[i];
		}

		// Find the GCD of the intermediate numerator and denominator
		int gcd = gcd(intermediateNumerator, intermediateDenominator);

		// Find the reduced numerator and denominator
		int finalNumerator = intermediateNumerator / gcd;
		int finalDenominator = intermediateDenominator / gcd;

		System.out.println(finalNumerator + "/" + finalDenominator);
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

}
