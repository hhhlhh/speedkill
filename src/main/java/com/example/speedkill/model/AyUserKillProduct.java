package com.example.speedkill.model;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ay_user_kill_product")
@Data
public class AyUserKillProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer state;
    private Date createTime;
    private Integer userId;


}
