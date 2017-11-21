package rd222dv_assign3;

public class EuclideanMain { //its all over the internet, but here is a link where i got it from: http://introcs.cs.princeton.edu/java/23recursion/Euclid.java.html
	public static int gcd(int num1, int num2) {
		while (true) {
			if (num2 == 0) {
				return num1;
			} else {
				int temp = num1;
				num1 = num2;
				num2 = temp % num2;
			}
		}
	}

	public static int recursiveGcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		} else {
			return gcd(num2, num1 % num2);
		}
	}

	public static void main(String[] args) {
		System.out.println(gcd(42, 56));
		System.out.println(recursiveGcd(42, 56));
	}
}
