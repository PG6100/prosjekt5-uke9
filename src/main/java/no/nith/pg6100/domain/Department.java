package no.nith.pg6100.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department extends BaseTimestampedObject{
    @Id
    @GeneratedValue
    private int departmentId;
    private String name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="department")
    public List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }
}
