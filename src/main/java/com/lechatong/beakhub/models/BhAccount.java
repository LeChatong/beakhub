package com.lechatong.beakhub.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bh_account")
public class BhAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "is_active")
    private String is_active;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
    private BhUser user;

    public BhAccount() {
    }

    public BhAccount(Integer id, String username, String password, Date last_login, String is_active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.last_login = last_login;
        this.is_active = is_active;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    /*public BhUser getUser() {
        return user;
    }*/

    public void setUser(BhUser user) {
        this.user = user;
    }
}
