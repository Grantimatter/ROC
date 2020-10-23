package string_builder_task;

import java.util.Scanner;

public class ValidatorMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input a phone number: ");
		String n = scanner.nextLine();
		MobileValidater validater = new MobileValidater();
		try {
			validater.validatePhoneNumber(n);
		} catch(InvalidMobileException e) {
			System.out.println(e.getMessage());
		}
	}
}
