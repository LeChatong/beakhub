package com.lechatong.beakhub.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bh_job")
public class BhJob implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BhCategory category;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BhUser user;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatdedAt;

    public BhJob() {
    }

    public BhJob(Integer id, String title, String description, BhCategory category, BhUser user, Date createdAt, Date updatdedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.user = user;
        this.createdAt = createdAt;
        this.updatdedAt = updatdedAt;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BhCategory getCategory() {
        return category;
    }

    public void setCategory(BhCategory category) {
        this.category = category;
    }

    public BhUser getUser() {
        return user;
    }

    public void setUser(BhUser user) {
        this.user = user;
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
