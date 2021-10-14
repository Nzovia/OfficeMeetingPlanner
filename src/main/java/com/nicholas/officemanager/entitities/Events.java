package com.nicholas.officemanager.entitities;

import javax.persistence.*;

@Entity
@Table(name = "meeting_events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long events_id;
    @Column(unique = true, nullable = false,length = 100)
    private String meeting_name;
    @Column(unique = true, nullable = false,length = 60)
    private String start_time;
    @Column(unique = true, nullable = false,length = 60)
    private String meeting_duration;
    @Column (unique = true, nullable = false, length = 255)
    private String event_description;

//    @OneToMany(mappedBy = "events")
//    private Set<Resources> resources = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "events")
//    private BoardRooms boardRooms;


    public Events() {
    }


    public Events(Long events_id, String meeting_name, String start_time, String meeting_duration, String event_description) {
        this.events_id = events_id;
        this.meeting_name = meeting_name;
        this.start_time = start_time;
        this.meeting_duration = meeting_duration;
        this.event_description = event_description;
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

    public String getMeeting_duration() {
        return meeting_duration;
    }

    public void setMeeting_duration(String end_time) {
        this.meeting_duration = end_time;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }
}