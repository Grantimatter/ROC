package task_combination;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Person {
	
	// Attributes each person should have
	private String name;
	private List<String> phoneNumbers;
	private int age;
	private double salary;
	
	// Empty constructor so that each property can be set separately
	public Person() {}
	
	public Person(String name, List<String> phoneNumbers, int age, double salary) {
		this.name = name;
		this.phoneNumbers = phoneNumbers;
		this.age = age;
		this.salary = salary;
	}
	
	public void printInfo() {
		System.out.println("Printing "+name);
		System.out.println("Name: "+ name);
		System.out.println("Age: "+age);
		String salaryString = NumberFormat.getCurrencyInstance(Locale.US).format(salary).toString();
		System.out.println("Salary: "+salaryString);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< phoneNumbers.size(); i++) {
			sb.append(phoneNumbers.get(i)+"\n");
		}
		System.out.println(sb.toString());
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
