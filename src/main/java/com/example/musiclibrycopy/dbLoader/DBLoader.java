package com.example.musiclibrycopy.dbLoader;


import com.example.musiclibrycopy.Artist;
import com.example.musiclibrycopy.Publisher;
import com.example.musiclibrycopy.Song;
import com.example.musiclibrycopy.commands.ArtistCommand;
import com.example.musiclibrycopy.repositories.ArtistRep;
import com.example.musiclibrycopy.repositories.PublisherRep;
import com.example.musiclibrycopy.repositories.SongRep;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ArtistRep artistRep;
    private SongRep songRep;
    private PublisherRep publisherRep;

    public DBLoader(ArtistRep artistRep, SongRep songRep, PublisherRep publisherRep) {
        this.artistRep = artistRep;
        this.songRep = songRep;
        this.publisherRep = publisherRep;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
    private void initData() {
        Artist artist1 = new Artist("name1", "lastName1", "nick1");
        Publisher publisher1 = new Publisher("publisher1", "nip1","adress1");
        Song song1 = new Song("title1", publisher1, "isbm1", "genre1");
        artist1.getSongs().add(song1);
        song1.getArtists().add(artist1);
        artistRep.save(artist1);
        publisherRep.save(publisher1);
        songRep.save(song1);

        Artist artist2 = new Artist("name2", "lastName2", "nick2");
        Publisher publisher2 = new Publisher("publisher2", "nip2","adress2");
        Song song2 = new Song("title2", publisher2, "isbm2", "genre2");
        artist2.getSongs().add(song2);
        song2.getArtists().add(artist2);
        artistRep.save(artist2);
        publisherRep.save(publisher2);
        songRep.save(song2);

        Artist artist3 = new Artist("name3", "lastName3", "nick3");
        Publisher publisher3 = new Publisher("publisher3", "nip3","adress3");
        Song song3 = new Song("title3", publisher3, "isbm3", "genre3");
        artist3.getSongs().add(song3);
        song3.getArtists().add(artist3);
        artistRep.save(artist3);
        publisherRep.save(publisher3);
        songRep.save(song3);
    }
}
