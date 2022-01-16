package com.kami.study.coursework.service;

import com.kami.study.coursework.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> allArtists(int page);
    List<Artist> allArtists();
    void add(Artist artist);
    void delete(Artist artist);
    void edit(Artist artist);
    Artist getById(int id);
    int artistsCount();
}
