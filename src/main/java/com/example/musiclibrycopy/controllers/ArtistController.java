package com.example.musiclibrycopy.controllers;

import com.example.musiclibrycopy.Artist;
import com.example.musiclibrycopy.commands.ArtistCommand;
import com.example.musiclibrycopy.converters.ArtistCommandToArtist;
import com.example.musiclibrycopy.converters.ArtistToArtistCommand;
import com.example.musiclibrycopy.repositories.ArtistRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class ArtistController {
    private ArtistRep artistRep;
    private ArtistCommandToArtist artistCommandToArtist;
    private ArtistToArtistCommand artistToArtistCommand;

    public ArtistController(ArtistRep artistRep, ArtistCommandToArtist artistCommandToArtist, ArtistToArtistCommand artistToArtistCommand) {
        this.artistRep = artistRep;
        this.artistCommandToArtist = artistCommandToArtist;
        this.artistToArtistCommand = artistToArtistCommand;
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
    @PostMapping(path = "artist")
    public String saveOrUpdate(@ModelAttribute("artistCommand") ArtistCommand command) {
        Optional<Artist> artistOptional = artistRep.findById(command.getId());
        if (!artistOptional.isPresent()) {
            Artist detechedArtist = artistCommandToArtist.convert(command);
            Artist savedArtist = artistRep.save(detechedArtist);
            return "redirect:/artist/" + savedArtist.getId() + "show";
        } else {
            Artist artistFromDatabase = artistOptional.get();
            artistFromDatabase.setFirstName(command.getFirstName());
            artistFromDatabase.setLastName(command.getLastName());
            artistFromDatabase.setNick(command.getNick());
            return "redirect:/artist/" + artistFromDatabase.getId() + "show"; //show jeszcze nie ma
            //        Artist detechedArtist = artistCommandToArtist.convert(command);
//        Artist savedArtist = artistRep.save(detechedArtist);
//        return "redirect:/artist/" + savedArtist.getId()+"show";
//    }

        }
    }

        @RequestMapping(path = "/artist/{id}/edit")
        public String updateArtist(Model model, @PathVariable("id") Long id){
            model.addAttribute("artistCommand", artistToArtistCommand.convert(artistRep.findById(id).get()));
            return "/addedit";
        }
        @RequestMapping(path = "/artis/{id}/show")
        public String showArtist(Model model, @PathVariable("id") Long id){
            model.addAttribute("artist", artistRep.findById(id).get());
            return "/show";
    }
@RequestMapping(path = "/artis/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        artistRep.deleteById(id);
        return "redirect:artist/list";
    }




}
