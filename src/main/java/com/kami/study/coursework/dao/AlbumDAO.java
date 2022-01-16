package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Album;

import java.util.List;


public interface AlbumDAO {
    List<Album> allAlbums(int page);
    List<Album> allAlbums();
    void add(Album album);
    void delete(Album album);
    void edit(Album album);
    Album getById(int id);
    int albumsCount();
}
