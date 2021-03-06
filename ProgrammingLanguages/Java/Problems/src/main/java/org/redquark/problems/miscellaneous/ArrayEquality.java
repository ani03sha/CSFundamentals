package org.redquark.problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two given arrays of equal length, the task is to find if given arrays
 * are equal or not. Two arrays are said to be equal if both of them contain
 * same set of elements, arrangements (or permutation) of elements may be
 * different though.
 * 
 * Note : If there are repetitions, then counts of repeated elements must also
 * be same for two array to be equal.
 * 
 * @author Anirudh Sharma
 *
 */
public class ArrayEquality {

	public static void main(String[] args) {

		// Arrays to be compared
		int[] a = { 3, 5, 2, 5, 2 };
		int[] b = { 2, 3, 5, 5, 2 };

		checkEquality(a, b);
	}

	/**
	 * This method checks if the two given arrays are equal or not
	 */
	private static void checkEquality(int[] a, int[] b) {

		// Lengths of arrays
		int l = a.length;
		int m = b.length;

		// If the length of two arrays are not equal then it means that arrays are not
		// equal
		if (l != m) {
			System.out.println("Arrays are not equal");
			return;
		}

		// Map that will store the count of each element in the array
		Map<Integer, Integer> countMap = new HashMap<>();
		// Counter that will store the count of elements in array
		int count = 0;

		// Iterate through array and store the count of each element in the HashMap
		for (int i = 0; i < l; i++) {
			if (countMap.containsKey(a[i])) {
				count = countMap.get(a[i]);
				countMap.put(a[i], count + 1);
			} else {
				countMap.put(a[i], 1);
			}
		}

		// Now we will traverse second array and determine if same elements are present
		// same number of times or not
		for (int i = 0; i < l; i++) {
			// If there is an element in b but not in a
			if (!countMap.containsKey(b[i])) {
				System.out.println("Arrays are not equal");
				return;
			}

			// If an element is found more number of times in b than in a
			if (countMap.get(b[i]) == 0) {
				System.out.println("Arrays are not equal");
				return;
			}

			// Getting the count of ith element in the second array
			count = countMap.get(b[i]);
			// Decrement the counter by 1
			--count;
			// And put the updated count
			countMap.put(b[i], count);
		}

		System.out.println("Arrays are equal");
	}
}
