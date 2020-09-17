package com.lechatong.beakhub.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bh_category")
public class BhCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    public BhCategory() {
    }

    public BhCategory(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
