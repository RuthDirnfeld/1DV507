package rd222dv_assign3.Chart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Histogram {

	// Fields
	private int upTo100 = 0;
	private String filePath = "";
	private int[] num = new int[10];
	private int other = 0;

	// Constructor
	public Histogram() {
	}

	public void setPath(String path) {
		filePath = path;
	}

	public boolean checkFileExist() { // if file exists
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	public void readFile() throws FileNotFoundException {
		if (checkFileExist() == true) { // check if it exists

			File file = new File(filePath);
			Scanner fileScan = new Scanner(file);

			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				int number = Integer.valueOf(line); // string to integer
													// conversion

				if (number <= 100 && number >= 1) { // number from 1 to 100

					upTo100++;

					if (number <= 10 && number > 0) {
						num[0] = num[0] + 1;
					} else if (number > 10 && number <= 20) {
						num[1] = num[1] + 1;
					} else if (number > 20 && number <= 30) {
						num[2] = num[2] + 1;
					} else if (number > 30 && number <= 40) {
						num[3] = num[3] + 1;
					} else if (number > 40 && number <= 50) {
						num[4] = num[4] + 1;
					} else if (number > 50 && number <= 60) {
						num[5] = num[5] + 1;
					} else if (number > 60 && number <= 70) {
						num[6] = num[6] + 1;
					} else if (number > 70 && number <= 80) {
						num[7] = num[7] + 1;
					} else if (number > 80 && number <= 90) {
						num[8] = num[8] + 1;
					} else {
						num[9] = num[9] + 1;
					}
				} else {
					other++; // if num is not in the interval from 1 to 100
				}
			}
			fileScan.close();
		} else
			throw new FileNotFoundException(); // throw error if not found

	}

	// Getters for the Main class
	public int getOthers() {return other;}

	public int getUpTo100() {return upTo100;}

	public int get1To10() {return num[0];}

	public int get11To20() {return num[1];}

	public int get21To30() {return num[2];}

	public int get31To40() {return num[3];}

	public int get41To50() {return num[4];}

	public int get51To60() {return num[5];}

	public int get61To70() {return num[6];}

	public int get71To80() {return num[7];}

	public int get81To90() {return num[8];}

	public int get91To100() {return num[9];}
}