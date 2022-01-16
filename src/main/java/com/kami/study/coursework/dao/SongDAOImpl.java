package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Song;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDAOImpl implements SongDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> allSongs(int page) {
        return sessionFactory.getCurrentSession().createQuery("from Song").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> allSongs() {
        return sessionFactory.getCurrentSession().createQuery("from Song").list();
    }

    @Override
    public int songsCount() {
        return sessionFactory.getCurrentSession().createQuery("select count(*) from Song", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Song song) {
        sessionFactory.getCurrentSession().persist(song);
    }

    @Override
    public void delete(Song song) {
        sessionFactory.getCurrentSession().delete(song);
    }

    @Override
    public void edit(Song song) {
        sessionFactory.getCurrentSession().update(song);
    }

    @Override
    public Song getById(int id) {
        return sessionFactory.getCurrentSession().get(Song.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> getByGenre(int genreId, int page) {
        return sessionFactory.getCurrentSession().createQuery("from Song where genre = " + genreId).setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> getByAlbum(int albumId) {
        return sessionFactory.getCurrentSession().createQuery("from Song where album = " + albumId).list();
    }
}
