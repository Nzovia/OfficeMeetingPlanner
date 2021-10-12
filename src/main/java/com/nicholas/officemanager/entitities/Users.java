package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(length = 60, nullable = false, unique = true)
    private String username;
    @Column(length = 80, nullable = false)
    private String password;
    @Column(unique = true, length = 70, nullable = false)
    private String employeeEmail;
//    @ManyToOne
//    private BoardRooms boardRooms;
//    @OneToMany(mappedBy = "users")
//    private List<Notifications> notifications= new ArrayList< >();
//    @OneToOne()
//    private  Employees employees;
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Roles> roles = new HashSet<>();

    public Users() {
    }

    public Users(Long user_id, String username, String password, String employeeEmail) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.employeeEmail = employeeEmail;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
