package com.example.musiclibrycopy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String nip;
    private String address;

    public Publisher(String name, String nip, String address) {
        this.name = name;
        this.nip = nip;
        this.address = address;
    }

    public Publisher() {

    }
}