package string_builder_task;

public class MobileValidater {
	// Checks if the number is valid and throws an exception if it is invalid
	public String validatePhoneNumber(String number) throws InvalidMobileException {
		number = number.replaceAll("\\D", "");
		
		if(number.length() < 10 || number.length() > 11) {
			throw new InvalidMobileException("A Phone number is either 10 digits or 11 with country code");
		}
		
		// Now that we know it is a valid number we can make it look a little nicer
		String formattedNumber = FormatNumber(number);
		System.out.println(formattedNumber + " parsed and validated succesfully");
		return formattedNumber;
		
	}
	
	// Formats the number to be more readable
	private String FormatNumber(String number) {
		int numSize = number.length();
		String str = new StringBuilder(number).insert(numSize-4, "-").insert(numSize-7, ") ").insert(numSize-10, "(").toString();
		if(numSize==11) {
			str = new StringBuilder(str).insert(0, "+").insert(2, " ").toString();
		}
		return str;
	}
}
