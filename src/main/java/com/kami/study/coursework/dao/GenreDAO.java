package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Genre;

import java.util.List;


public interface GenreDAO {
    List<Genre> allGenres(int page);
    List<Genre> allGenres();
    void add(Genre genre);
    void delete(Genre genre);
    void edit(Genre genre);
    Genre getById(int id);
    int genresCount();
}
