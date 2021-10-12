package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meeting_events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long events_id;
    @Column(unique = true, nullable = false,length = 60)
    private String meeting_name;
    @Column(unique = true, nullable = false,length = 60)
    private String start_time;
    @Column(unique = true, nullable = false,length = 60)
    private String end_time;

//    @OneToMany(mappedBy = "events")
//    private Set<Resources> resources = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "events")
//    private BoardRooms boardRooms;


    public Events() {
    }

    public Events(Long events_id, String meeting_name, String start_time, String end_time) {
        this.events_id = events_id;
        this.meeting_name = meeting_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Long getEvents_id() {
        return events_id;
    }

    public void setEvents_id(Long events_id) {
        this.events_id = events_id;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}