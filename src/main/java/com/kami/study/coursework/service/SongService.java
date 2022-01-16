package com.kami.study.coursework.service;

import com.kami.study.coursework.model.Song;

import java.util.List;

public interface SongService {
    List<Song> allSongs(int page);
    List<Song> allSongs();
    void add(Song song);
    void delete(Song song);
    void edit(Song song);
    Song getById(int id);
    int songsCount();
    List<Song> getByGenre(int genreId, int page);
    List<Song> getByAlbum(int albumId);
}
