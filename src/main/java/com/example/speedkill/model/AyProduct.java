package com.example.speedkill.model;

import lombok.Data;
import sun.util.calendar.BaseCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name= "ay_product")
public class AyProduct implements Serializable {
    @Id
    private Integer id;
    private String productImg;
    private String name;
    private Integer number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

}
