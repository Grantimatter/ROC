package eg1;

public class EmsMain {
    public static void main(String[] args) {
        EMS revEmp = new RevatureEmployer();
        revEmp.addEmployee();
        revEmp.commonEmployeeBenifits();
        revEmp.updateEmployee();
        revEmp.calculateEmployeeSalary();
        revEmp.deleteEmployee();

        //System.out.println("\n\nAccessing EMS");
    }
}
