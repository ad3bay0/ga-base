package com.ad3bay0.gatest.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="episodes")
@Getter @Setter
public class Episode extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private String episodeCode;

    @ManyToMany
    private List<Character> characters;

    @OneToMany(mappedBy = "episode")
    private List<Comment> episodeComments;
    
}