package com.lechatong.beakhub.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bh_address")
public class BhAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "country")
    private String country;

    @Column(name = "town")
    private String town;

    @Column(name = "street")
    private String street;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number_1", nullable = false)
    private String phone_number_1;

    @Column(name = "phone_number_2")
    private String phone_number_2;

    @JoinColumn(name = "job_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BhJob job;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatdedAt;

    public BhAddress() {
    }

    public BhAddress(Integer id, String title, String country, String town, String street, String website,
                     String phone_number_1, String phone_number_2, BhJob job, Date createdAt, Date updatdedAt) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.town = town;
        this.street = street;
        this.website = website;
        this.phone_number_1 = phone_number_1;
        this.phone_number_2 = phone_number_2;
        this.job = job;
        this.createdAt = createdAt;
        this.updatdedAt = updatdedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhone_number_1() {
        return phone_number_1;
    }

    public String getPhone_number_2() {
        return phone_number_2;
    }

    public BhJob getJob() {
        return job;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatdedAt() {
        return updatdedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhone_number_1(String phone_number_1) {
        this.phone_number_1 = phone_number_1;
    }

    public void setPhone_number_2(String phone_number_2) {
        this.phone_number_2 = phone_number_2;
    }

    public void setJob(BhJob job) {
        this.job = job;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatdedAt(Date updatdedAt) {
        this.updatdedAt = updatdedAt;
    }
}
