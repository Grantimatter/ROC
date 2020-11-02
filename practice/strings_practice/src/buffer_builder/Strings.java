package buffer_builder;

public class Strings {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println("sb = "+sb);
		sb.append(" Hello").append(" hey").append(" java").append(1233).append(12.66666f);
		System.out.println(sb);
		sb.insert(1, "Hibernate");
		System.out.println(sb);
		StringBuffer sb1 = new StringBuffer("vinay");
		StringBuffer sb2 = new StringBuffer("vinay");
		System.out.println(sb1.equals(sb2)); // Address -> equals is not overridden in buffer & builder classes
		System.out.println(sb1.toString().equals(sb2.toString()));
		
	}

}
