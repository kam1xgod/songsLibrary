package com.kami.study.coursework.service;

import com.kami.study.coursework.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> allGenres(int page);
    List<Genre> allGenres();
    void add(Genre genre);
    void delete(Genre genre);
    void edit(Genre genre);
    Genre getById(int id);
    int genresCount();
}
