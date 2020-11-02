package regex;

public class RegularExpressionExample {

	public static void main(String[] args) {
		/*
		 * Regular Expression(RegEx) - Pattern Matching
		 * 
		 * [] 				-	Expression
		 * {}				-	Length
		 * ^				-	Not
		 * [a-z]{5}			-	Any lower case word of length 5
		 * [0-9A-Z]{4}		-	Any alphanumeric word of length 4 (alphas should be in upper case)
		 * [a-zA-Z]{2,6}	-	Any word with a minimum length of 2 and a maximum length of 6
		 * [A-Z]{1,}		-	Minimum 1 upper case letter
		 * [^0-9]			-	Apart from digits
		 * 
		 */
		
		String s="  H    E     &** *LL   1   234Oa   )  a199_";
		System.out.println(s.replaceAll("[^a-zA-Z]",""));
		System.out.println(s.replaceAll("[A-Z]", 	""));
		System.out.println(s.replaceAll("[a-zA-Z]",	""));
		System.out.println(s.replaceAll("[^0-9]",	""));
		System.out.println(s.replaceAll("[0-9a-zA-Z]",""));
		
		//A String that starts with 5 upper case letters followed by 4 digits and an upper case letter
		String s1="ABCFZ5490L";
		String s2="L0945ZFCBA";
		if(s1.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			System.out.println("Validated");
		}else {
			System.out.println("Invalid");
		}
	}

}
