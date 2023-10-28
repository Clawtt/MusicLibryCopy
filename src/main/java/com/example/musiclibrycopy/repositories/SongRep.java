package com.example.musiclibrycopy.repositories;

import com.example.musiclibrycopy.Song;
import org.springframework.data.repository.CrudRepository;


public interface SongRep extends CrudRepository<Song, Long> {
}
