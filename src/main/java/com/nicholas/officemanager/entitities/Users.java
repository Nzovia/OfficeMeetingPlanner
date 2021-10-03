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
    @ManyToOne
    private BoardRooms boardRooms;
    @OneToMany(mappedBy = "users")
    private List<Notifications> notifications= new ArrayList< >();
    @OneToOne()
    private  Employees employees;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles = new HashSet<>();

    public Users() {
    }

    public Users(Long user_id, String username, String password, String employeeEmail, BoardRooms boardRooms, List<Notifications> notifications,
                 Employees employees, Set<Roles> roles) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.employeeEmail = employeeEmail;
        this.boardRooms = boardRooms;
        this.notifications = notifications;
        this.employees = employees;
        this.roles = roles;
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

    public BoardRooms getBoardRooms() {
        return boardRooms;
    }

    public void setBoardRooms(BoardRooms boardRooms) {
        this.boardRooms = boardRooms;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    //create a new method for adding roles to this user
    public void addRole(Roles roles){
        this.roles.add(roles);
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", boardRooms=" + boardRooms +
                ", notifications=" + notifications +
                ", employees=" + employees +
                ", roles=" + roles +
                '}';
    }
}
