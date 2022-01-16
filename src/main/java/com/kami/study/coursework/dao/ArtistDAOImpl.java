package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Artist;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistDAOImpl implements ArtistDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Artist> allArtists(int page) {
        return sessionFactory.getCurrentSession().createQuery("from Artist").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Artist> allArtists() {
        return sessionFactory.getCurrentSession().createQuery("from Artist").list();
    }

    @Override
    public int artistsCount() {
        return sessionFactory.getCurrentSession().createQuery("select count(*) from Artist", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Artist artist) {
        sessionFactory.getCurrentSession().persist(artist);
    }

    @Override
    public void delete(Artist artist) {
        sessionFactory.getCurrentSession().delete(artist);
    }

    @Override
    public void edit(Artist artist) {
        sessionFactory.getCurrentSession().update(artist);
    }

    @Override
    public Artist getById(int id) {
        return sessionFactory.getCurrentSession().get(Artist.class, id);
    }
}
