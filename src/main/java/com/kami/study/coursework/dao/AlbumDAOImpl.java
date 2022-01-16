package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Album;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDAOImpl implements AlbumDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Album> allAlbums(int page) {
        return sessionFactory.getCurrentSession().createQuery("from Album").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @SuppressWarnings("uncheked")
    @Override
    public List<Album> allAlbums() {
        return sessionFactory.getCurrentSession().createQuery("from Album").list();
    }

    @Override
    public int albumsCount() {
        return sessionFactory.getCurrentSession().createQuery("select count(*) from Album", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Album album) {
        sessionFactory.getCurrentSession().persist(album);
    }

    @Override
    public void delete(Album album) {
            sessionFactory.getCurrentSession().delete(album);
    }

    @Override
    public void edit(Album album) {
        sessionFactory.getCurrentSession().update(album);
    }

    @Override
    public Album getById(int id) {
        return sessionFactory.getCurrentSession().get(Album.class, id);
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Artist> getByGenre(int artistId, int page) {
//        return sessionFactory.getCurrentSession().createQuery("from Artist where song = " + genreId).setFirstResult(10 * (page - 1)).setMaxResults(10).list();
//    }
}
