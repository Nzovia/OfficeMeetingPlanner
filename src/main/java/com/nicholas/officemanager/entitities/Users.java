package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Users {
    @Id()
    @GeneratedValue(generator= "incrementId", strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(nullable = false,length = 60)
    private String firstName;
    @Column(nullable = false,length = 60)
    private String secondName;
    @Column(nullable = false,length = 60)
    private String empgender;
    @Column(unique = true, nullable = false,length = 60)
    private String empphone;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_email;

//    @ManyToOne()
//    @JoinColumn(name="organization_id")
//    private Organization organization;
//    @OneToOne()
//    private  Users users;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn (name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set <Roles> roles = new HashSet<>();

    public Users() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmpgender() {
        return empgender;
    }

    public void setEmpgender(String empgender) {
        this.empgender = empgender;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}