package rd222dv_assign3.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {
	public static void main(String[] args) {

		int[] unsorted = { 4, 1, 8, -3, 5, 7 };
		int[] in = insertionSort(unsorted);

		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i] + ", ");
		}
		String[] inn = { "Jens", "Jonas", "TestForLongest", "Anna", "Morgan" }; //this is copy pasted from the slides
		Comparator<String> byLength = (String o1, String o2) -> o1.length() - o2.length();
		insertionSort(inn, byLength);
		for (int i = 0; i < 5; i++)
			System.out.println("\n" + inn[i]);

		int[] merge = mergeSort(unsorted);
		System.out.println("\n" + Arrays.toString(merge));
		
		String [] merge1 = mergeSort(inn, byLength);
        System.out.println(Arrays.toString(merge1));
	}

	public static int[] insertionSort(int[] sort) { // got inspired by Big Java Late Objects by Cay Horstmann p. 638;
												
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

	public static String[] insertionSort(String[] in, Comparator<String> c) { // inspired by http://algs4.cs.princeton.edu/21elementary/Insertion.java.html

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

	public static int[] mergeSort(int[] in) { // this one is all over the
												// Internet but just in case,
												// here is a link:
												// http://web.cs.iastate.edu/~smkautz/cs227f16/examples/week11/MergeSort.java
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

	public static String[] mergeSort(String[] in, Comparator<String> c) {
		String[] temp = in;

		if (temp.length <= 1) {
			return temp;
		}

		String[] string1 = new String[temp.length / 2];
		String[] string2 = new String[temp.length - string1.length];

		for (int i = 0; i < string1.length; i++) {
			string1[i] = temp[i];
		}

		for (int i = 0; i < string2.length; i++) {
			string2[i] = temp[string1.length + i];
		}

		mergeSort(string1, c); //recursively
		mergeSort(string2, c);

		// Merge
		int iString1 = 0;
		int iString2 = 0;
		int j = 0;

		while (iString1 < string1.length && iString2 < string2.length) {
			if (c.compare(string1[iString1], string2[iString2]) > 0) {
				temp[j] = string1[iString1];
				iString1++;
			} else {
				temp[j] = string2[iString2];
				iString2++;
			}
			j++;

			while (iString1 < string1.length) {
				temp[j] = string1[iString1];
				iString1++;
				j++;
			}
			while (iString2 < string2.length) {
				temp[j] = string2[iString2];
				iString2++;
				j++;
			}
		}
		return temp;
	}
}
