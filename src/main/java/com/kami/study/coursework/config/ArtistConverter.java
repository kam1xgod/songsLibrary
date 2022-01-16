package com.kami.study.coursework.config;

import com.kami.study.coursework.model.Artist;
import com.kami.study.coursework.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("artistConverter")
public class ArtistConverter implements Converter<String, Artist> {
    final ArtistService artistService;

    @Autowired
    public ArtistConverter(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public Artist convert(String id) {
        return artistService.getById(Integer.parseInt(id));
    }
}
