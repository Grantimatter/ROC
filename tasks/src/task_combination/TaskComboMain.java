package task_combination;
import java.util.*;

import string_builder_task.*;

public class TaskComboMain {
	public static void main(String[] args) {
		// Create a list of people that we will receive info for from the user and will be populated by our other packages.
		List<Person> people = new ArrayList<Person>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people will you be adding to the list?");
		int peopleCount = scanner.nextInt();
		
		// For each number of people that are going to be entered, ask for the new input again. Always runs at least once.
		do {
			Person newPerson = RetrieveInformation.retrieveAllInfo();
			people.add(newPerson);
		} while(people.size() < peopleCount);

		for(Person p:people) {
			p.printInfo();
			System.out.println();
		}
	}
}
