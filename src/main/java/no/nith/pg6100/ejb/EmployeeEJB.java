package no.nith.pg6100.ejb;

import no.nith.pg6100.domain.Employee;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
@LocalBean
public class EmployeeEJB implements EmployeeRemote{

    @PersistenceContext(unitName = "PG6100")
    private EntityManager em;

    @EJB
    private DepartmentRemote departmentEJB;


    public void deleteAllEmployees(boolean cascadeDepartments) {
      
    
     
   
  
 
    }

    public Employee createEmployee(Employee employee) {


        return  null;
    }


    public List<Employee> listAllEmployees() {
        
       
        return  null;
    }


}
