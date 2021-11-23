package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Column(nullable = false,unique = true)
    private String roleTitle;

    public Roles() {

    }

    public Roles(Long role_id, String roleTitle) {
        this.role_id = role_id;
        this.roleTitle = roleTitle;
    }

    public Roles(String users) {
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String name) {
        this.roleTitle = name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", roleTitle='" + roleTitle + '\'' +
                '}';
    }
}
