package com.kami.study.coursework.service;

import com.kami.study.coursework.dao.ArtistDAO;
import com.kami.study.coursework.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    final ArtistDAO artistDAO;

    @Autowired
    public ArtistServiceImpl(ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @Override
    @Transactional
    public List<Artist> allArtists(int page) {
        return artistDAO.allArtists(page);
    }

    @Override
    @Transactional
    public List<Artist> allArtists() {
        return artistDAO.allArtists();
    }

    @Override
    @Transactional
    public int artistsCount() {
        return artistDAO.artistsCount();
    }

    @Override
    @Transactional
    public void add(Artist artist) {
        artistDAO.add(artist);
    }

    @Override
    @Transactional
    public void delete(Artist artist) {
        artistDAO.delete(artist);
    }

    @Override
    @Transactional
    public void edit(Artist artist) {
        artistDAO.edit(artist);
    }

    @Override
    @Transactional
    public Artist getById(int id) {
        return artistDAO.getById(id);
    }
}
