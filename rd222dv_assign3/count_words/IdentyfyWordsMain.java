package rd222dv_assign3.count_words;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IdentyfyWordsMain {
	public static void main(String[] args) throws IOException {
		try{
		File in = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\HistoryOfProgramming.txt"); //reading file
		File out = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\words.txt"); //path where the new file should be created
		FileWriter fWriter = new FileWriter(out); 
		BufferedWriter bw = new BufferedWriter(fWriter); //the writers for the file

		Scanner fileScan = new Scanner(in); //scanner for the file to read

		while (fileScan.hasNext()) { //reading the file
			String ln = fileScan.nextLine();

			ln = ln.replaceAll("[^A-Za-z-\']", " "); //"[^a-zA-Z0-9]" // ("[^a-zA-Z\\s]+") //replacing all the bad characters with " "
			bw.write(ln); //writing to buffer
		}

		if (!out.exists()) {
			out.createNewFile();
		}
		bw.close(); //very important!!!closing the bufferWriter
		}
		catch (FileNotFoundException e) {
            System.out.println("Wrong path! File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Wrong path!");
            e.printStackTrace();
        }
	}
}

// String[]words = text.split("[a-z]+"); /("[a-zA-Z]*"); "[a-zA-Z]+\\s")
// [a-zA-Z:], " "