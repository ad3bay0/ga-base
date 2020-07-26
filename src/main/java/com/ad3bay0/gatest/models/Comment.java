package com.ad3bay0.gatest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter @Setter
public class Comment extends BaseModel{

    @Column(nullable = false, length = 250)
    private String comment;

    @Column(nullable = false, name = "ip_address_location")
    private String ipAddressLocation;

    @ManyToOne
    private Episode episode;
    
    
}