package operators;

public class Operations {
	public static int add(int a, int b) {
		int n = a + b;
		System.out.println(a+" + "+b+" = "+n);
		return n;
	}

	public static int subtract(int a, int b) {
		int n = a - b;
		System.out.println(a+" - "+b+" = "+n);
		return n;
	}

	public static float divide(float a, float b) {
		float n = a/b;
		System.out.println(a+" ÷ "+b+" = "+n);
		return n;
	}

	public static boolean equalTo(int a, int b) {
		boolean t = (a == b);
		if(t)
			System.out.println(a+" is equal to "+b);
		else
			System.out.println(a+" is NOT equal to "+b);
		return t;
	}

	public static boolean equalTo(String a, String b) {
		boolean t = (a == b);
		if(t)
			System.out.println(a+" is equal to "+b);
		else
			System.out.println(a+" is NOT equal to "+b);
		return t;
	}

	public static float modulo(int a, int b) {
		float m = a % b;
		System.out.println(a+" % "+b+" = "+m);
		return m;
	}

	public static boolean notEqualTo(int a, int b) {
		boolean t = (a != b);
		return t;
	}

	public static boolean notEqualTo(String a, String b) {
		boolean t = (a != b);
		return t;
	}
}
