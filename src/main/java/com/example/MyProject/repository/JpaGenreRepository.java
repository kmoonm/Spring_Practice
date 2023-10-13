package com.example.MyProject.repository;

import com.example.MyProject.domain.Genre;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaGenreRepository implements GenreRepository{

    private final EntityManager em;

    public JpaGenreRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Genre genreSave(Genre genre) {
        em.persist(genre);
        return genre;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        Genre genre = em.find(Genre.class, id);
        return Optional.ofNullable(genre);
    }

    @Override
    public Optional<Genre> findByName(String genre) {
        List<Genre> result = em.createQuery("select g from genre g where g.genre_name = :genre_name", Genre.class)
                .setParameter("genre_name", genre)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Genre> findAll() {
        return em.createQuery("select g from genre g", Genre.class)
                .getResultList();
    }
}
