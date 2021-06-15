package com.example.datainteraction.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
// 定义实体类

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String userphone;

    @Column
    private String userpassword;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datatime;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}