package com.example.speedkill.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name= "ay_user")
@Data
public class AyUser implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String phoneNumber;
}
