package rd222dv_assign4.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Exercise3 {
	public static void main(String[] args) {

		//timeInsertionSort();
		// timeStringInsertionSort();
		 timeIntMergeSort();

	}

	public static void timeInsertionSort() {

		int[] insertArr = randArray(20, 40);
		int estimatedTime = 0;
		while (estimatedTime < 1000) {
			long before = System.currentTimeMillis();
			insertionSort(insertArr);
			long after = System.currentTimeMillis();
			estimatedTime = (int) (after - before);
			System.out.println("Int time: " + estimatedTime + " millisec.  Total length: " + insertArr.length);
			
			//increasing and decreasing the size of the array slowly so that the while loop does not stop
			if (estimatedTime == 999 || estimatedTime == 1000 || estimatedTime == 1001) { //breaking it to get a result
				break;
			} else if (estimatedTime > 1001 && estimatedTime <= 1050) {
				insertArr = randArray(insertArr.length - 1, insertArr.length * 2); 
				estimatedTime = 0;
			} else if (estimatedTime > 1050) {
				insertArr = randArray(insertArr.length - 500, insertArr.length * 2);
				estimatedTime = 0;
			} else if (estimatedTime <= 950) {
				insertArr = randArray(insertArr.length + 100, insertArr.length * 2);
				estimatedTime = 0;
			} else {
				insertArr = randArray(insertArr.length + 1, insertArr.length * 2);
			}
		}
	}

	public static void timeIntMergeSort() {

		int[] insertArr = randArray(20, 40);
		int estimatedTime = 0;
		while (estimatedTime < 1000) {
			long before = System.currentTimeMillis();
			mergeSort(insertArr);
			long after = System.currentTimeMillis();
			estimatedTime = (int) (after - before);
			System.out.println(
					"Merge Int time: " + estimatedTime + " millisec.  Total length: " + insertArr.length);

			if (estimatedTime == 999 || estimatedTime == 1000 || estimatedTime == 1001) {
				break;
			} else if (estimatedTime > 1001 && estimatedTime <= 1050) {
				insertArr = randArray(insertArr.length - 1, insertArr.length * 2);
				estimatedTime = 0;
			} else if (estimatedTime <= 950) {
				insertArr = randArray(insertArr.length + 1000, insertArr.length * 2);
			} else if (estimatedTime > 1050) {
				insertArr = randArray(insertArr.length - 1000, insertArr.length * 2);
			} else {
				insertArr = randArray(insertArr.length + 1, insertArr.length * 2);
			}
		}
	}

	public static void timeStringInsertionSort() {

		String[] insertionArr = randomStringArray(100, 300);
		Comparator<String> c = null;
		int estimatedTime = 0;
		while (estimatedTime < 1000) {
			long before = System.currentTimeMillis();
			insertionSort(insertionArr, c);
			long after = System.currentTimeMillis();
			estimatedTime = (int) (after - before);
			System.out.println(
					"String time: " + estimatedTime + " millisec.  Total length: " + insertionArr.length);

			if (estimatedTime == 999 || estimatedTime == 1000 || estimatedTime == 1001) {
				break;
			} else if (estimatedTime > 1001 && estimatedTime <= 1050) {
				insertionArr = randomStringArray(insertionArr.length - 1, insertionArr.length * 2);
				estimatedTime = 0;
			} else if (estimatedTime > 1050) {
				insertionArr = randomStringArray(insertionArr.length - 250, insertionArr.length * 2);
				estimatedTime = 0;
			} else if (estimatedTime <= 950) {
				insertionArr = randomStringArray(insertionArr.length + 500, insertionArr.length * 2);
			} else {
				insertionArr = randomStringArray(insertionArr.length + 1, insertionArr.length * 2);
			}
		}
	}

	/*the two random array methods*/
	private static String[] randomStringArray(int length, int n) {
		Random rand = new Random();
		String[] arr = new String[length];
		String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		if (n >= letter.length || n <= 0)
			n = letter.length;
		StringBuilder sb;
		for (int i = 0; i < arr.length; i++) {
			sb = new StringBuilder();
			int size = 0;
			while (size != 10) {
				sb.append(letter[rand.nextInt(n)]);
				size++;
			}
			arr[i] = sb.toString();
		}
		return arr;
	}

	private static int[] randArray(int length, int n) {
		Random rand = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}

	/* all methods taken from assign3 */

	public static int[] insertionSort(int[] sort) {

		for (int i = 1; i < sort.length; i++) {
			int temp = sort[i];
			int j = i;
			while (j > 0 && sort[j - 1] > temp) {
				sort[j] = sort[j - 1];
				j--;
			}
			sort[j] = temp;
		}
		return sort;
	}

	public static String[] insertionSort(String[] in, Comparator<String> c) { // inspired
																				// by
																				// http://algs4.cs.princeton.edu/21elementary/Insertion.java.html

		String[] temp1 = in;

		for (int i = 1; i < temp1.length; i++) {
			String temp2 = temp1[i];
			int j = i;
			while ((j > 0) && c.compare(temp2, temp1[j - 1]) > 0) {
				temp1[j] = temp1[j - 1];
				j--;
			}
			temp1[j] = temp2;
		}
		return temp1;
	}

	public static int[] mergeSort(int[] in) { 
		int[] newArray = in;

		if (newArray.length <= 1) {
			return newArray;
		}

		int half = newArray.length / 2;
		int[] arr1 = new int[half];
		int[] arr2 = new int[newArray.length - arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = newArray[i];
		}

		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = newArray[half++];
		}

		arr1 = mergeSort(arr1); // recursively saving arr1 and arr2
		arr2 = mergeSort(arr2);

		int iarr1 = 0; // merge
		int iarr2 = 0;
		int j = 0;

		while (iarr1 < arr1.length && iarr2 < arr2.length) {
			if (arr1[iarr1] < arr2[iarr2]) {
				newArray[j] = arr1[iarr1];
				iarr1++;
			} else {
				newArray[j] = arr2[iarr2];
				iarr2++;
			}
			j++;

		}
		while (iarr1 < arr1.length) {
			newArray[j] = arr1[iarr1];
			iarr1++;
			j++;
		}

		while (iarr2 < arr2.length) {
			newArray[j] = arr2[iarr2];
			iarr2++;
			j++;
		}

		return newArray;
	}

}
/* used Resources:
 *https://github.com/sarpreetsingh3131/1DV507-Programming-
 * and-Data-Structures/blob/master/sb223ce_assign4/
 * sb223ce_assign4/Exercise4/Experiment.java*/
