package com.example.musiclibrycopy.commands;

//Klasa command jest niezbędna aby oddzielić obiekty encji od warstwy widoku. Technika ta polega na stworzeniu
//uproszczonych baz danych(nazwane command), które będą odwolywały sie do obiektów encji i komunikowały z widokiem (odpowiadać na zapytania get)

//w kolejnym kroku należy stworzyć klasy, które będą konwertować encje do command i command do encji - patrz package commands

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
public class ArtistCommand {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
}
