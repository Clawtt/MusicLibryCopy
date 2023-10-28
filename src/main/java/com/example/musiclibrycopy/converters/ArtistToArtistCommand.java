package com.example.musiclibrycopy.converters;

import com.example.musiclibrycopy.Artist;
import com.example.musiclibrycopy.commands.ArtistCommand;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ArtistToArtistCommand implements Converter<Artist, ArtistCommand> {

    @Synchronized
    @Nullable
    @Override
    public ArtistCommand convert(Artist source) {
        final ArtistCommand artistCommand = new ArtistCommand();
        artistCommand.setId(source.getId());
        artistCommand.setFirstName(source.getFirstName());
        artistCommand.setLastName(source.getLastName());
        artistCommand.setNick(source.getNick());
        return artistCommand;
    }
}
