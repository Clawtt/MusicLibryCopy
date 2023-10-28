package com.example.musiclibrycopy.controllers;

import com.example.musiclibrycopy.repositories.SongRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongController{
    private SongRep songRep;

    public SongController(SongRep songRep) {
        this.songRep = songRep;
    }

    @RequestMapping("/song")
    public String getSong(Model model) {
        model.addAttribute("songs", songRep.findAll());
        return "song";
    }
}
