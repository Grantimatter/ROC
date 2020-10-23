package eg1;

public class RevatureEmployer extends EMS {

    @Override
    public void addEmployee() {
        System.out.println("Added employee");
    }

    @Override
    public void updateEmployee() {
        System.out.println("Updated employee");
    }

    @Override
    public void calculateEmployeeSalary() {
        System.out.println("Calculated employee salary");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Deleted employee");
    }
}
