package com.kami.study.coursework.config;

import com.kami.study.coursework.model.Genre;
import com.kami.study.coursework.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("genreConverter")
public class GenreConverter implements Converter<String, Genre> {
    final GenreService genreService;

    @Autowired
    public GenreConverter(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Genre convert(String id) {
        return genreService.getById(Integer.parseInt(id));
    }
}
