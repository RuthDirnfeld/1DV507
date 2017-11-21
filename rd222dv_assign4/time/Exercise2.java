package rd222dv_assign4.time;

import java.lang.System; //The class java.lang.System supports time measurements

public class Exercise2 {
	private static int longStrLength = 80;
	private static String longStr="";

	public static void main(String[] args) {

	    for (int i = 0; i < longStrLength ; i++) {
	      longStr += "z";

	    }
	    
		for (int i = 0; i < 5; i++) {

			stringOneCharacter();
			string80Characters();
			stringBuilderOneCharacter();
			//stringBuilder80Character();
		}
	}
	/*Java8 slide 40
	Instant start = Instant.now();
	doSomethingMethod();
	Instant end = Instant.now();
	Duration timeElapsed = Duration.between(start, end);
	long millis = timeElapsed.toMillis();
	*/
	public static void stringOneCharacter() { //how many short strings can be added in one second

		String string = ""; //initialize empty string
		long before = System.currentTimeMillis();
		while (System.currentTimeMillis() - before < 1000) { //run until 1second is reached
			string = string + "z";
		}
		long after = System.currentTimeMillis();
		int estimatedTime = (int) (after - before); //time in milliseconds, difference between before and after is the estimatedTime
		System.out.println("Short String: Time: " + estimatedTime + " milliseconds.  Concatenations: "
				+ string.length() + ".  Total length: " + string.length() + "\n");
	}

	public static void string80Characters() {

		String string = "";
		long before = System.currentTimeMillis();
		while (System.currentTimeMillis() - before < 1000) {
			string = string + longStr;

		}
		long after = System.currentTimeMillis();
		int estimatedTime = (int) (after - before);
		System.out.println("Long String: Time: " + estimatedTime + " milliseconds.  Concatenations: "
				+ (string.length() / 80) + ".  Total length: " + string.length() + "\n");
	}

	public static void stringBuilderOneCharacter() {

		StringBuilder str = new StringBuilder();
		long before = System.currentTimeMillis();
		while (System.currentTimeMillis() - before < 1000) {
			str.append("a");
		}
		long after = System.currentTimeMillis();
		int estimatedTime = (int) (after - before);

		long start = System.currentTimeMillis();
		str.toString();
		long finish = System.currentTimeMillis();
		int toStringTime = (int) (finish - start);

		StringBuilder newBuilder = new StringBuilder();
		long startPoint = System.currentTimeMillis();
		while (System.currentTimeMillis() - startPoint < 1000 - toStringTime) {
			newBuilder.append("a");
		}
		long endPoint = System.currentTimeMillis();
		int newEstimatedTime = (int) (endPoint - startPoint);
		
		System.out.println("Before ToString:  Time: " + estimatedTime + " milliseconds." +
				 " Concatenations: " + str.length() + ".  Total length: " + str.length());
		System.out.println("ToString time: " + toStringTime + " milliseconds.");
		System.out.println("After ToString:  Time: " + (newEstimatedTime + toStringTime)
				+ " milliseconds.  Concatenations: " + newBuilder.length() + ".  Total Length: "
				+ newBuilder.length() + "\n");

	}
	
	public static void stringBuilder80Character() {

		StringBuilder str = new StringBuilder();
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str.append(longStr);
		}
		long end = System.currentTimeMillis();
		int estimatedTime = (int) (end - start);

		long begin = System.currentTimeMillis();
		str.toString();
		long finish = System.currentTimeMillis();
		int toStringTime = (int) (finish - begin);

		StringBuilder newBuilder = new StringBuilder();
		long startPoint = System.currentTimeMillis();
		while (System.currentTimeMillis() - startPoint < 1000 - toStringTime) {
			newBuilder.append(longStr);
		}
		long endPoint = System.currentTimeMillis();
		int newEstimatedTime = (int) (endPoint - startPoint);
		
		System.out.println("Before ToString:  Time: " + estimatedTime + " milliseconds."
				+ " Concatenations: " + str.length() + ".  Total length: " + str.length());
		System.out.println("ToString time: " + toStringTime + " milliseconds.");
		System.out.println("After ToString:  Time: " + (newEstimatedTime + toStringTime)
				+ " milliseconds.  Concatenation: " + (newBuilder.length() / 80) + ".  Total Length: "
				+ newBuilder.length() + "\n");
	}
}

