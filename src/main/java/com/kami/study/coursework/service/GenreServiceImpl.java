package com.kami.study.coursework.service;

import com.kami.study.coursework.dao.GenreDAO;
import com.kami.study.coursework.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    final GenreDAO genresDAO;

    @Autowired
    public GenreServiceImpl(GenreDAO genresDAO) {
        this.genresDAO = genresDAO;
    }

    @Override
    @Transactional
    public List<Genre> allGenres(int page) {
        return genresDAO.allGenres(page);
    }

    @Override
    @Transactional
    public List<Genre> allGenres() {
        return genresDAO.allGenres();
    }

    @Override
    @Transactional
    public int genresCount() {
        return genresDAO.genresCount();
    }

    @Override
    @Transactional
    public void add(Genre genre) {
        genresDAO.add(genre);
    }

    @Override
    @Transactional
    public void delete(Genre genre) {
        genresDAO.delete(genre);
    }

    @Override
    @Transactional
    public void edit(Genre genre) {
        genresDAO.edit(genre);
    }

    @Override
    @Transactional
    public Genre getById(int id) {
        return genresDAO.getById(id);
    }
}
