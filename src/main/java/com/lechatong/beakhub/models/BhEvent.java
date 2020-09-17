package com.lechatong.beakhub.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bh_event")
public class BhEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BhUser user;

    @JoinColumn(name = "event_type_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BhEventType eventType;

    @Column(name = "date_event")
    private Date date_event;

    public BhEvent() {
    }

    public BhEvent(String description, BhUser user, BhEventType eventType, Date date_event) {
        this.description = description;
        this.user = user;
        this.eventType = eventType;
        this.date_event = date_event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BhUser getUser() {
        return user;
    }

    public void setUser(BhUser user) {
        this.user = user;
    }

    public BhEventType getEventType() {
        return eventType;
    }

    public void setEventType(BhEventType eventType) {
        this.eventType = eventType;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }
}
