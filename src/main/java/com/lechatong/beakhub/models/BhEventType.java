package com.lechatong.beakhub.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bh_event_type")
public class BhEventType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    public BhEventType() {
    }

    public BhEventType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
