package task_combination;
import java.util.*;

import string_builder_task.*;

public class TaskComboMain {
	public static void main(String[] args) {
		List<String> numberList = new ArrayList();
		MobileValidater validater = new MobileValidater();
		
		// Receive a list of phone numbers from user and add them to a list correctly formatted and display them back when finished
		// Currently has bug where directions are not printed the second time but every time after it is fine
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.print("Type a phone number");
				
				if(!numberList.isEmpty()) {
					System.out.print(" or type \"quit\" to finish");
				}
				
				System.out.println();
				String num = scanner.nextLine();
				numberList.add(validater.validatePhoneNumber(num));
			} catch(InvalidMobileException e) {
				System.out.println(e.getMessage());
			}
			
		}while(!scanner.hasNext("quit") || numberList.isEmpty());
		
		System.out.println("Phone Number List : "+numberList);
	}
}
