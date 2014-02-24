package no.nith.pg6100.domain;


import javax.persistence.*;

@Entity
public class Employee extends BaseTimestampedObject{

    @Id
    @GeneratedValue
    private int employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String  lastName;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)  // en avdeling har mange ansatte
    public Department department;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int personId) {
        this.employeeId = personId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
