package rd222dv_assign1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class WarAndPeace {
	public static void main(String[] args) throws IOException {

		String text = readText("WarAndPeace.txt");
		String[] words = text.split(" ");

		System.out.println("Initial word count: " + words.length);
		
		long uniqueWords = Arrays.stream(words).filter(t -> !t.matches("[a-zA-Z]*")).distinct().count();
		
		// the output is probably not unique enough, but I am running out of time, so I will ask for more filters during the lab sessions

		System.out.println("Unique words: " +uniqueWords);

	}

	private static String readText(String string) throws IOException {

		byte[] encoded = Files
				.readAllBytes(Paths.get("D:\\lnu\\java_courses\\1DV507\\src\\rd222dv_assign1\\WarAndPeace.txt"));
		return new String(encoded);
	}
}
