package com.example.musiclibrycopy.repositories;

import com.example.musiclibrycopy.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ArtistRep extends CrudRepository<Artist, Long> {
}
