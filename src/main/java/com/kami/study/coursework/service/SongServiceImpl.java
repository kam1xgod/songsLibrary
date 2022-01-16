package com.kami.study.coursework.service;

import com.kami.study.coursework.dao.SongDAO;
import com.kami.study.coursework.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    final SongDAO songDAO;

    @Autowired
    public SongServiceImpl(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    @Override
    @Transactional
    public List<Song> allSongs(int page) {
        return songDAO.allSongs(page);
    }

    @Override
    @Transactional
    public List<Song> allSongs() {
        return songDAO.allSongs();
    }

    @Override
    @Transactional
    public int songsCount() {
        return songDAO.songsCount();
    }

    @Override
    @Transactional
    public void add(Song song) {
        songDAO.add(song);
    }

    @Override
    @Transactional
    public void delete(Song song) {
        songDAO.delete(song);
    }

    @Override
    @Transactional
    public void edit(Song song) {
        songDAO.edit(song);
    }

    @Override
    @Transactional
    public Song getById(int id) {
        return songDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Song> getByGenre(int genreId, int page) {
        return songDAO.getByGenre(genreId, page);
    }

    @Override
    @Transactional
    public List<Song> getByAlbum(int albumId) {
        return songDAO.getByAlbum(albumId);
    }
}
