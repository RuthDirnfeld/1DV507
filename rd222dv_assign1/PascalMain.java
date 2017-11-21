package rd222dv_assign1;

import java.util.Arrays;

public class PascalMain {
	public static void main(String[] args) {
		System.out.println("Line 6 of Pascal's Triangle is " + Arrays.toString(pascalRow(6)));
		// System.out.println(pascalRow(10));
	}

	public static int[] pascalRow(int n) {

		if (n < 0)
			throw new IllegalArgumentException("Row must be positive");
		
		int[] num = new int[n + 1];
		int[] row = new int[num.length];

		num[0] = 1;
		num[n] = 1;

		if (n == 0)
			return num;

		row = pascalRow(n - 1);

		for (int i = 1; i < row.length; i++) {

			num[i] = row[i - 1] + row[i];
		}

		return num;
	}
}
/*int[] pasTriangle = new int[n + 1];
	if (n == 0) {
	pasTriangle[0] = 1;
	return pasTriangle;
}
	int[] ppt = pascalRow(n - 1);
	pasTriangle[0] = pasTriangle[n] = 1;
	for (int i = 1; i < ppt.length; i++) {
		pasTriangle[i] = ppt[i - 1] + ppt[i];
}
	return pasTriangle;*/
