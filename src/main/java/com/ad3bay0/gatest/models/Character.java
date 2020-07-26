package com.ad3bay0.gatest.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ad3bay0.gatest.enums.Gender;
import com.ad3bay0.gatest.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="characters")
public class Character extends BaseModel{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "state_of_origin")
    private String stateOfOrigin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @OneToOne(mappedBy = "character")
    private Location location;

    @ManyToMany(mappedBy = "characters")
    private List<Episode> episodes;
    
}