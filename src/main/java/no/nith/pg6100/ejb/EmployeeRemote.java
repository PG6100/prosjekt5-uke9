package no.nith.pg6100.ejb;

import no.nith.pg6100.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeRemote {

    public void deleteAllEmployees(boolean cascadeDepartments);

    public Employee createEmployee(Employee e);

    public List<Employee> listAllEmployees();

}
