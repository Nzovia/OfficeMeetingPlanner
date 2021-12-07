package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
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
    @Column(unique = true, nullable = false,length = 60)
    private String empPassword;
    private boolean enabled;
    @Column(unique = true, updatable = false)
    private String verificationCode;
    @Column(name="account_non_locked", nullable = false)
    private boolean accountNonLocked;
    @Column(name="failedAttempts")
    private  int failedAttempt;
    @Column(name="locked_duration")
    private Date lockTime;

//    @ManyToOne()
//    @JoinColumn(name="organization_id")
//    private Organization organization;
//    @OneToOne()
//    private  Users users;
    @ManyToMany(fetch = FetchType.EAGER)
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

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public int getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(int failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

//    @Override
//    public String toString() {
//        return "Users{" +
//                "employeeId=" + employeeId +
//                ", firstName='" + firstName + '\'' +
//                ", secondName='" + secondName + '\'' +
//                ", empgender='" + empgender + '\'' +
//                ", empphone='" + empphone + '\'' +
//                ", employee_email='" + employee_email + '\'' +
//                ", empPassword='" + empPassword + '\'' +
//                ", enabled=" + enabled +
//                ", verificationCode='" + verificationCode + '\'' +
//                ", roles=" + roles +
//                '}';
//    }
}