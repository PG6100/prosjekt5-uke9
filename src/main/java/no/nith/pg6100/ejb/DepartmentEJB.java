package no.nith.pg6100.ejb;

import no.nith.pg6100.domain.Department;
import no.nith.pg6100.domain.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
@LocalBean
public class DepartmentEJB implements DepartmentRemote{
    @PersistenceContext(unitName = "PG6100")
    private EntityManager em;

    public List<Department> listAllDepartments() {

return null;

    }

    public void deleteAllDepartments() {


    }

    public Department findDepartment(int id) {
        return null;
    }
}
