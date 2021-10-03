package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notification_id;
    @Column(nullable = false,length = 60)
    private String notification_name;
    @Column(nullable = false,length = 60)
    private String notification_description;
    @Column(unique = true, nullable = false,length = 60)
    private String employee_id;
    @ManyToOne
    @JoinColumn(name="users_id")
    private Users users;

    public Notifications() {
    }

    public Notifications(Long notification_id, String notification_name,
                         String notification_description, String employee_id, Users users) {
        this.notification_id = notification_id;
        this.notification_name = notification_name;
        this.notification_description = notification_description;
        this.employee_id = employee_id;
        this.users = users;

    }

    public Long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_name() {
        return notification_name;
    }

    public void setNotification_name(String notification_name) {
        this.notification_name = notification_name;
    }

    public String getNotification_description() {
        return notification_description;
    }

    public void setNotification_description(String notification_description) {
        this.notification_description = notification_description;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "notification_id=" + notification_id +
                ", notification_name='" + notification_name + '\'' +
                ", notification_description='" + notification_description + '\'' +
                ", employee_id='" + employee_id + '\'' +
                "users=" + users +
                '}';
    }
}
