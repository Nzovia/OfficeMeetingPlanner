package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "resources")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resource_id;
    @Column(unique = true, nullable = false,length = 60)
    private String resource_name;
    @Column(nullable = false,length = 200)
    private String resource_description;
//    @ManyToOne
//    @JoinColumn(name = "resources")
//    private Events events;

    public Resources() {
    }

    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getResource_description() {
        return resource_description;
    }

    public void setResource_description(String resource_description) {
        this.resource_description = resource_description;
    }
}
