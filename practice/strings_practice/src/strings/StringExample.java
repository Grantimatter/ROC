package strings;

public class StringExample {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = "HI";

		System.out.println("s1.hashCode() : " + s1.hashCode());
		System.out.println("s2.hashcode() : " + s2.hashCode());
		System.out.println("s3.hashcode() : " + s3.hashCode());
		System.out.println("s4.hashCode() : " + s4.hashCode());

		System.out.println("System.identityHashCode(s1) : " + System.identityHashCode(s1));
		System.out.println("System.identityHashCode(s2) : " + System.identityHashCode(s2));
		System.out.println("System.identityHashCode(s3) : " + System.identityHashCode(s3));
		System.out.println("System.identityHashCode(s4) : " + System.identityHashCode(s4));

		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);

		System.out.println("s1.equals(s2) : " + s1.equals(s2));
		System.out.println("s1.equals(s3) : " + s1.equals(s3));
		System.out.println("s1.equals(s4) : " + s1.equals(s4));

		System.out.println("s1.equalsIgnoreCase(\"HELLo\") : " + s1.equalsIgnoreCase("HELLo"));
		System.out.println("s1.equals(\"HELLo\") : " + s1.equals("HELLo"));

		System.out.println();
		String s5 = "Hello on this fine morning my fellow colleagues!";
		String[] s6 = s5.split(" ");

		char[] ca = new char[s5.length()];
		for (int i = 0; i < ca.length; i++) {
			ca[i] = s5.charAt(i);
			System.out.println(ca[i]);
		}

		for (String s : s6) {
			System.out.println(s.toUpperCase());

		}
		
		String s7 = "                                       Hello                             ";
		System.out.println(s7);
		s7 = s7.trim();
		System.out.println(s7);
	}

}
