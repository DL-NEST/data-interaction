package com.example.datainteraction.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
// 定义实体类

@Entity
@Data
public class temperature {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer classid;

    @Column(length = 20)
    private String classname;

    @Column(length = 6)
    private float temperature;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datatime1;


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getDatatime1() {
        return datatime1;
    }

    public void setDatatime1(Date datatime1) {
        this.datatime1 = datatime1;
    }
}