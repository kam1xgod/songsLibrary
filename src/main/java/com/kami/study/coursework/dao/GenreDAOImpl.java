package com.kami.study.coursework.dao;

import com.kami.study.coursework.model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genre> allGenres(int page) {
        return sessionFactory.getCurrentSession().createQuery("from Genre ").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genre> allGenres() {
        return sessionFactory.getCurrentSession().createQuery("from Genre ").list();
    }

    @Override
    public void add(Genre genre) {
        sessionFactory.getCurrentSession().persist(genre);
    }

    @Override
    public void delete(Genre genre) {
        sessionFactory.getCurrentSession().delete(genre);
    }

    @Override
    public void edit(Genre genre) {
        sessionFactory.getCurrentSession().update(genre);
    }

    @Override
    public Genre getById(int id) {
        return sessionFactory.getCurrentSession().get(Genre.class, id);
    }

    @Override
    public int genresCount() {
        return sessionFactory.getCurrentSession().createQuery("select count(*) from Genre", Number.class).getSingleResult().intValue();
    }
}
