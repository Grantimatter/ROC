package task_combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import string_builder_task.InvalidMobileException;
import string_builder_task.MobileValidater;

public class RetrieveInformation {
	
	private static Scanner scanner;
	
	public static Person retrieveAllInfo() {
		scanner = new Scanner(System.in);
		
		Person person = new Person();
		String name = retrieveName();
		person.setName(name);
		person.setAge(retrieveAge(name));
		person.setSalary(retrieveSalary(name));
		
		
		List<String> allNumbers = new ArrayList<String>();
		allNumbers.add(retrievePhoneNumbers(name).toString());
		person.setPhoneNumbers(allNumbers);
		
		return person;
	}
	
	public static double retrieveSalary(String name) {
		try {
			System.out.println("Please input "+name+"'s salary");
			return scanner.nextDouble();
		} catch(Exception e) {
			
		}
		return 0.00;
	}
	
	public static String retrieveName() {
		try {
			System.out.println("Please input the person's name");
			return scanner.nextLine();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public static int retrieveAge(String name) {
		try {
			System.out.println("Please input "+name+"'s age");
			return scanner.nextInt();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}

	public static List<String> retrievePhoneNumbers(String name) {
		List<String> numberList = new ArrayList<String>();
		MobileValidater validater = new MobileValidater();

		// Receive a list of phone numbers from user and add them to a list correctly
		// formatted and display them back when finished
		// Currently has bug where directions are not printed the second time but every
		// time after it is fine
		String num = "";
		do {
			try {
				System.out.print("What is "+name+"'s phone number?");

				// Add exit instructions after first entry is added to the list
				if (!numberList.isEmpty()) {
					System.out.print(" or type \"quit\" to finish");
				}

				System.out.println();
				System.out.println();
				num = scanner.nextLine();
				numberList.add(validater.validatePhoneNumber(num));
			} catch (InvalidMobileException e) {
				System.out.println(e.getMessage());
			}

		} while (!scanner.hasNext("quit") || numberList.isEmpty());

		return numberList;
	}
}
