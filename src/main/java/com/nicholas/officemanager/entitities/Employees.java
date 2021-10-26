package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {
    @Id()
    @GeneratedValue(generator= "incrementId", strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(nullable = false,length = 60)
    private String firstName;
    @Column(nullable = false,length = 60)
    private String secondName;
    @Column(nullable = false,length = 60)
    private String employee_gender;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_phone;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_email;

//    @ManyToOne()
//    @JoinColumn(name="organization_id")
//    private Organization organization;
//    @OneToOne()
//    private  Users users;

    public Employees() {
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

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }
}