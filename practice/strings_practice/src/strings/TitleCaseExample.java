package strings;

public class TitleCaseExample {

	public static void main(String[] args) {
		String s = "good morning my fellow colleagues! have a great day!";
		StringBuilder sb = new StringBuilder();
		String ar[]=s.split(" ");
		for(String s1:ar) {
			sb.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
