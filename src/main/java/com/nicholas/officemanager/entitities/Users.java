package com.nicholas.officemanager.entitities;

import javax.persistence.*;

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

    public Users() {
    }

    public Users(Long employeeId, String firstName, String secondName, String empgender,
                 String empphone, String employee_email) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.empgender = empgender;
        this.empphone = empphone;
        this.employee_email = employee_email;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employee_id) {
        this.employeeId = employee_id;
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

    public void setEmpgender(String employee_gender) {
        this.empgender = employee_gender;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String employee_phone) {
        this.empphone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }
}