package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organization_id;
    @Column(unique = true, nullable = false,length = 60)
    private String organization_name;
    @Column(nullable = false,length = 255)
    private String organization_description;

//    @OneToMany(mappedBy = "organization")
//    private List<Employees> employees = new ArrayList<>();
    public Organization() {
    }

    public Organization(Long organization_id, String organization_name, String organization_description) {
        this.organization_id = organization_id;
        this.organization_name = organization_name;
        this.organization_description = organization_description;
    }

    public Long getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Long organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getOrganization_description() {
        return organization_description;
    }

    public void setOrganization_description(String organization_description) {
        this.organization_description = organization_description;
    }
}