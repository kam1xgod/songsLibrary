package com.kami.study.coursework.service;

import com.kami.study.coursework.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> allAlbums(int page);
    List<Album> allAlbums();
    void add(Album album);
    void delete(Album album);
    void edit(Album album);
    Album getById(int id);
    int albumsCount();
}
