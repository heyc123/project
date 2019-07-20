package com.heyc.gasstation.softem.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
public abstract class Entity<PK extends Serializable> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private PK id;
    @Column(name="DELETED")
    private String deleted = "F";
}
