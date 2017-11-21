package rd222dv_assign1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PrintJavaMain {
	
	public static void main(String[] args) {
		File currentDirectory = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign1"); // current directory
		printAllJavaFiles(currentDirectory);
	}

	public static void printAllJavaFiles(File directory) {
		try {
			File[] files = directory.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("Directory: " + file.getCanonicalPath());
					printAllJavaFiles(file);
				} else {
					int line = 0;
					Scanner sc = new Scanner(file);
					while(sc.hasNextLine()){
						line++;
						sc.nextLine();
					}
					sc.close();
					System.out.println("File: " + file.getCanonicalPath() +" + Number of lines: "+line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
