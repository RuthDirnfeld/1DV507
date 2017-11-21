package rd222dv_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\words.txt");
		Scanner fileScan = new Scanner(file);

		HashSet<Word> nwHashSet = new HashSet<>();
		while (fileScan.hasNext()) {
			Word word = new Word(fileScan.next());
			nwHashSet.add(word);
		}
		fileScan.close();
		
		File file2 = new File("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign3\\words.txt");
		Scanner fileScan2 = new Scanner(file2);

		TreeSet<Word> nwTreeSet = new TreeSet<>();
		while (fileScan2.hasNext()) {
			Word word = new Word(fileScan2.next());
			nwTreeSet.add(word);
		}
		fileScan2.close();
		
		System.out.println("Hash words: " + nwHashSet.size() +" words: "+ nwHashSet.toString());
		System.out.println("Tree words: " + nwTreeSet.size() +" words: "+ nwTreeSet.toString());

	}
}
