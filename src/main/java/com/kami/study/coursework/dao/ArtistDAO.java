package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Artist;

import java.util.List;


public interface ArtistDAO {
    List<Artist> allArtists(int page);
    List<Artist> allArtists();
    void add(Artist artist);
    void delete(Artist artist);
    void edit(Artist artist);
    Artist getById(int id);
    int artistsCount();
}
