package no.nith.pg6100.ejb;

import no.nith.pg6100.domain.Department;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DepartmentRemote {

    public List<Department> listAllDepartments();

    public void deleteAllDepartments();

    public Department findDepartment(int id);
}
