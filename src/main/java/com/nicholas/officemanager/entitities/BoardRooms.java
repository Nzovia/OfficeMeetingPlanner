package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "boardrooms")
public class BoardRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardroom_id;
    @Column(unique = true, nullable = false,length = 60)
    private String boardroom_name;
    @Column(nullable = false,length = 60)
    private String boardroom_capacity;
    @Column(nullable = false,length = 60)
    private String boardroom_resources;
//    @OneToMany(mappedBy="boardRooms")
//    private List<Users> users = new ArrayList<>();
    @OneToMany(mappedBy = "boardRooms")
    private Set<Events> events= new HashSet<>();

    public BoardRooms() {
    }

    public BoardRooms(Long boardroom_id, String boardroom_name, String boardroom_capacity,
                      String boardroom_resources, Set<Events> events) {
        this.boardroom_id = boardroom_id;
        this.boardroom_name = boardroom_name;
        this.boardroom_capacity = boardroom_capacity;
        this.boardroom_resources = boardroom_resources;
        this.events = events;
    }

    public Long getBoardroom_id() {
        return boardroom_id;
    }

    public void setBoardroom_id(Long boardroom_id) {
        this.boardroom_id = boardroom_id;
    }

    public String getBoardroom_name() {
        return boardroom_name;
    }

    public void setBoardroom_name(String boardroom_name) {
        this.boardroom_name = boardroom_name;
    }

    public String getBoardroom_capacity() {
        return boardroom_capacity;
    }

    public void setBoardroom_capacity(String boardroom_capacity) {
        this.boardroom_capacity = boardroom_capacity;
    }

    public String getBoardroom_resources() {
        return boardroom_resources;
    }

    public void setBoardroom_resources(String boardroom_resources) {
        this.boardroom_resources = boardroom_resources;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }
}