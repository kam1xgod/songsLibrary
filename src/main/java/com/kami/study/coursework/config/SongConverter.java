package com.kami.study.coursework.config;

import com.kami.study.coursework.model.Song;
import com.kami.study.coursework.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("songConverter")
public class SongConverter implements Converter<String, Song> {
    final SongService songService;

    @Autowired
    public SongConverter(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song convert(String id) {
        return songService.getById(Integer.parseInt(id));
    }
}
