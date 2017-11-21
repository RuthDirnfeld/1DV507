package rd222dv_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\words.txt");
		Scanner fileScan = new Scanner(file);

		HashWordSet hash = new HashWordSet();
		while (fileScan.hasNext()) {
			Word word = new Word(fileScan.next());
			hash.add(word);
		}
		fileScan.close();

		File file2 = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\words.txt");
		Scanner fileScan2 = new Scanner(file2);

		TreeWordSet tree = new TreeWordSet();
		while (fileScan2.hasNext()) {
			Word word = new Word(fileScan2.next());
			tree.add(word);
		}
		fileScan2.close();
		
		System.out.println("Hash words: " + hash.size() + " words: " + hash.toString());
		System.out.println("Tree words: " + tree.size() + " words: " + tree.toString());

	}
}
