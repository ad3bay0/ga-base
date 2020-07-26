package com.ad3bay0.gatest.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime created;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modified;
    
}