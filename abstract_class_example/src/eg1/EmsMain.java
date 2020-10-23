package eg1;

import java.util.Iterator;

public class EmsMain {
    public static void main(String[] args) {
        EMS revEmp = new RevatureEmployer();
        revEmp.addEmployee();
        revEmp.commonEmployeeBenifits();
        revEmp.updateEmployee();
        revEmp.calculateEmployeeSalary();
        revEmp.deleteEmployee();

        String a = "java";
        a = a.substring(0, 1).toUpperCase() + a.substring(1);
        System.out.println(a);
        //System.out.println("\n\nAccessing EMS");
    }
}
