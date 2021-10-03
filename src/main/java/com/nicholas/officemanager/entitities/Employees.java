package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 60)
    private String employee_name;
    @Column(nullable = false,length = 60)
    private String employee_gender;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_phone;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_email;

    @ManyToOne()
    @JoinColumn(name="organization_id")
    private Organization organization;
    @OneToOne()
    private  Users users;

    public Employees() {
    }

    public Employees(Long id, String employee_name, String employee_gender, String employee_phone, String employee_email,
                     Organization organization) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_gender = employee_gender;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_gender='" + employee_gender + '\'' +
                ", employee_phone='" + employee_phone + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", organization=" + organization +
                '}';
    }
}