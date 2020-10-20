package eg2;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee e1 = new Employee(100, "Johnathan", 123456789);
		e1.setCity("Dubai");
		System.out.println("\nPrinting e1");
		e1.printEmployee();
		
		
		Employee e2 = new Employee(101, "Jackson", 876452213);
		System.out.println("\nPrinting e2");
		e2.setCity("Longview");
		e2.printEmployee();
		
		Employee e3 = new Employee(102, "Julie", 22567214, "Austin", "Julie@gmail.com");
		System.out.println("\nPrinting e3");
		e3.printEmployee();
		
		Employee e4 = new Employee(103, "Jackie", 123511234, "Jacksonville", "Jackie@gmail.com");
		System.out.println("\nPrinting e4");
		e4.printEmployee();
	}
}
