package com.example.datainteraction.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// 定义实体类

@Entity
@Data
public class temperature {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String time;

    private float temperature;

//    private Boolean srt(){
//
//    }
//    public String getname(){
//        return username;
//    }
//    public String getphone(){
//        return userphone;
//    }
//    public String getpassword(){
//        return userpassword;
//    }
}