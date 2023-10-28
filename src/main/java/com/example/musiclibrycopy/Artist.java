package com.example.musiclibrycopy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.HashSet;
import java.util.Set;

@Data //Anotacja z pakietu Lombok, który zastępuje boilerplate code (zwieksza widoczność)
@EqualsAndHashCode(of = {"id"}) // ta adnotacja pozwala wybrać pole po którym ma porównywać metoda equals w encjach
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;

    @ManyToMany(mappedBy = "artists")
    private Set<Song> songs = new HashSet<>();

    public Artist() {
    }

    public Artist(String firstName, String lastName, String nick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
    }
}
