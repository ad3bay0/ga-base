package com.ad3bay0.gatest.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany
    private List<Character> characters;

    @JsonIgnore
    @OneToMany(mappedBy = "episode")
    private List<Comment> episodeComments;

    public void addComment(Comment comment){
        
        this.episodeComments.add(comment);
        comment.setEpisode(this);
    }
    
}