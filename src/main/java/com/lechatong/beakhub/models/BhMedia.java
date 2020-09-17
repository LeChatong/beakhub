package com.lechatong.beakhub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bh_media")
public class BhMedia {
    @Id
    @Column(name = "id_media")
    private int id_media;

    @Column(name = "url_media")
    private String url_media;

    @Column(name = "type_media")
    private String type_media;
}
