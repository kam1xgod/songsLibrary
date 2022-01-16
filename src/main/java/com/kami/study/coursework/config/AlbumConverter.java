package com.kami.study.coursework.config;

import com.kami.study.coursework.model.Album;
import com.kami.study.coursework.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("albumConverter")
public class AlbumConverter implements Converter<String, Album> {
    final AlbumService albumService;

    @Autowired
    public AlbumConverter(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public Album convert(String id) {
        return albumService.getById(Integer.parseInt(id));
    }
}