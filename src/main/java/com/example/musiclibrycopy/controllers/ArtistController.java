package com.example.musiclibrycopy.controllers;

import com.example.musiclibrycopy.Artist;
import com.example.musiclibrycopy.commands.ArtistCommand;
import com.example.musiclibrycopy.converters.ArtistCommandToArtist;
import com.example.musiclibrycopy.repositories.ArtistRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {
    private ArtistRep artistRep;
    private ArtistCommandToArtist artistCommandToArtist;

    public ArtistController(ArtistRep artistRep, ArtistCommandToArtist artistCommandToArtist) {
        this.artistRep = artistRep;
        this.artistCommandToArtist = artistCommandToArtist;
    }

    @RequestMapping("/artist/list")
    public String getArtist(Model model) {
        model.addAttribute("artists", artistRep.findAll());
        return "artist";
    }

    //WYJAŚNIENIE
//w metodzie newArtist pobraliśmy dane które użytkownik nam przekazał i wyslaliśmy je do atrybutu modelu w instancji klasy ArtistCommand, która jest
//łącznikiem między widokiem, a encjami(bazą danych) - innymi słowy oddziela widok od bazy danych
//następnie w metodzie saveOrUpdate bierzemy ten atrybut, który wysłaliśmy do modelu i go obsługujemy(odsyłamy np. informacje, że zapis się powiódł)


    @GetMapping(path = "/artist/new")
    public String newArtist(Model model) {
        model.addAttribute("artistCommand", new ArtistCommand());
        return "addedit";
    }
    @PostMapping(path = {"artist"})
    public String saveOrUpdate(@ModelAttribute ArtistCommand command) {
        Artist detechedArtist = artistCommandToArtist.convert(command);
        Artist savedArtist = artistRep.save(detechedArtist);
        return ("redirect:/artist/" + savedArtist.getId());
    }
}
