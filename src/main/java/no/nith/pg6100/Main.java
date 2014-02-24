package no.nith.pg6100;

import no.nith.pg6100.domain.Department;
import no.nith.pg6100.domain.Employee;
import no.nith.pg6100.ejb.DepartmentRemote;
import no.nith.pg6100.ejb.EmployeeRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        EmployeeRemote ejb =(EmployeeRemote) context.lookup("no.nith.pg6100.ejb.EmployeeRemote");
        ejb.deleteAllEmployees(true);
        DepartmentRemote depEJB=(DepartmentRemote) context.lookup(DepartmentRemote.class.getName().replace(".class",""));
        Employee e = new Employee();
        e.setFirstName("Ola5");
        e.setLastName("Nordman6");
        Department dept = new Department();
        dept.setName("Salg");
        //Department dept = depEJB.findDepartment(2);
        e.setDepartment(dept);
        ejb.createEmployee(e);
        printEmployees(ejb);

        printDepartments(depEJB);
    }

    private static void printEmployees(EmployeeRemote ejb) {
        SimpleDateFormat f=new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println("listing employees: ");
        List<Employee> employees = ejb.listAllEmployees();
        System.out.println("______________________________________________________________________________");
        System.out.println("ID\tFirstname\tLastname\tDepartment\tTime_stamp");
        System.out.println("______________________________________________________________________________");

        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeId()+"\t"+employee.getFirstName()+"\t"+employee.getLastName()+"\t"+employee.getDepartment()+"\t"+f.format(employee.getModifiedTimestamp()));
        }
    }

    private static void printDepartments(DepartmentRemote ejb) throws NamingException {
        System.out.println("\n\n\nLooking up department ejb...");
        System.out.println("Departments");
        System.out.println("===============================================================");
        SimpleDateFormat f=new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println("listing departments: ");
        List<Department> deparmtents = ejb.listAllDepartments();
        System.out.println("______________________________________________________________________________");
        System.out.println("ID\tname\t# employees\tTime_stamp");
        System.out.println("______________________________________________________________________________");

        for (Department department : deparmtents) {
            System.out.println(department.getDepartmentId()+"\t"+department.getName()+"\t"+department.getEmployees().size()+"\t"+f.format(department.getModifiedTimestamp()));
        }
    }
}