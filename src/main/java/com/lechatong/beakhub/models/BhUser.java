package com.lechatong.beakhub.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

enum  Gender {
    MALE,
    FEMALE
}

@Entity
@Table(name = "bh_user")
public class BhUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "whatsapp_phone")
    private String whatsapp_phone;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "profile_picture")
    private String profile_picture;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private BhAccount account;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatdedAt;

    public BhUser() {
    }

    public BhUser(Integer id, String first_name, String last_name, String email, String whatsapp_phone, String phone_number,
                  String profile_picture,
                  Date date_of_birth, BhAccount account, Date createdAt, Date updatdedAt) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.whatsapp_phone = whatsapp_phone;
        this.phone_number = phone_number;
        this.profile_picture = profile_picture;
        this.date_of_birth = date_of_birth;
        this.account = account;
        this.createdAt = createdAt;
        this.updatdedAt = updatdedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp_phone() {
        return whatsapp_phone;
    }

    public void setWhatsapp_phone(String whatsapp_phone) {
        this.whatsapp_phone = whatsapp_phone;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public BhAccount getAccount() {
        return account;
    }

    public void setAccount(BhAccount account) {
        this.account = account;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatdedAt() {
        return updatdedAt;
    }

    public void setUpdatdedAt(Date updatdedAt) {
        this.updatdedAt = updatdedAt;
    }
}
