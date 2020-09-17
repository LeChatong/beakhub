package com.lechatong.beakhub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "bh_company")
public class BhCompany {
    @Id
    @Column(name = "id_company")
    private int id_company;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "website")
    private String website;

    @Column(name = "post_box")
    private String post_box;

    @Column(name = "email")
    private String email;

    @Column(name = "profile_path")
    private String profile_path;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;
}
