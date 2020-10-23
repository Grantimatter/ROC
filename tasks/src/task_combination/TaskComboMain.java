package task_combination;
import java.util.*;

import string_builder_task.*;

public class TaskComboMain {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people will you be adding to the list?");
		int peopleCount = scanner.nextInt();
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
