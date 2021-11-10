package com.nicholas.officemanager.entitities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "meeting_events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long events_id;
    @Column(unique = true, nullable = false,length = 100)
    private String meeting_name;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date start_time;
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private java.util.Date end_time;
    @Column (unique = true, nullable = false, length = 255)
    private String event_description;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date meeting_date;

//    @OneToMany(mappedBy = "events")
//    private Set<Resources> resources = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "events")
//    private BoardRooms boardRooms;


    public Events() {

    }

    public Events(Long events_id, String meeting_name, Time start_time, Time end_time, String event_description, Date meeting_date) {
        this.events_id = events_id;
        this.meeting_name = meeting_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.event_description = event_description;
        this.meeting_date = meeting_date;
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

    public java.util.Date getStart_time() {
        return start_time;
    }

    public void setStart_time(java.util.Date start_time) {
        this.start_time = start_time;
    }

    public java.util.Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(java.util.Date end_time) {
        this.end_time = end_time;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public java.util.Date getMeeting_date() {
        return meeting_date;
    }

    public void setMeeting_date(java.util.Date meeting_date) {
        this.meeting_date = meeting_date;
    }

}