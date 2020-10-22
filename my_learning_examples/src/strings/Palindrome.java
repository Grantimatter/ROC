package strings;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		String s = "";
		Scanner scanner = new Scanner(System.in);
		
		while(!s.equalsIgnoreCase("quit")) {
			s = scanner.nextLine();
			
			//Remove all white space to disregard words and phrases with spaces
			String snw = "";
			for(char c:s.toCharArray()) {
				if(!Character.isWhitespace(c)) {
					snw+=c;
				}
			}

			if(new StringBuffer(snw).reverse().toString().equalsIgnoreCase(snw))
				System.out.println(s + " is a palindrome");
			else
				System.out.println(s + " is not a palindrome");
		}
		
	}

}
