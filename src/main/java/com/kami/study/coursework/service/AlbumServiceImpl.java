package com.kami.study.coursework.service;

import com.kami.study.coursework.dao.AlbumDAO;
import com.kami.study.coursework.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    final AlbumDAO albumDAO;

    @Autowired
    public AlbumServiceImpl(AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    @Override
    @Transactional
    public List<Album> allAlbums(int page) {
        return albumDAO.allAlbums(page);
    }

    @Override
    @Transactional
    public List<Album> allAlbums() {
        return albumDAO.allAlbums();
    }

    @Override
    @Transactional
    public int albumsCount() {
        return albumDAO.albumsCount();
    }

    @Override
    @Transactional
    public void add(Album artist) {
        albumDAO.add(artist);
    }

    @Override
    @Transactional
    public void delete(Album artist) {
        albumDAO.delete(artist);
    }

    @Override
    @Transactional
    public void edit(Album artist) {
        albumDAO.edit(artist);
    }

    @Override
    @Transactional
    public Album getById(int id) {
        return albumDAO.getById(id);
    }
}
