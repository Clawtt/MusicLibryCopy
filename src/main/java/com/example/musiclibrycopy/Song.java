package com.example.musiclibrycopy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

@Data //Anotacja z pakietu Lombok, który zastępuje boilerplate code
@EqualsAndHashCode(of = {"id"})
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    private Publisher publisher;
    private String isbm;
    private String genre;
    @ManyToMany
    private Set<Artist> artists = new HashSet<>();

    public Song(String title, Publisher publisher, String isbm, String genre) {
        this.title = title;
        this.publisher = publisher;
        this.isbm = isbm;
        this.genre = genre;
    }

    public Song() {

    }
}
