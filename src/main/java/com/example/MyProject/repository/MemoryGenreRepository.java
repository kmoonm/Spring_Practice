package com.example.MyProject.repository;

import com.example.MyProject.domain.Genre;

import java.util.*;

public class MemoryGenreRepository implements GenreRepository{

    private static final Map<Long, Genre> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Genre genreSave(Genre genre1) {
        genre1.setId(++sequence);
        store.put(genre1.getId(), genre1);
        return genre1;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Genre> findByName(String genre) {
        return store.values().stream()
                .filter(genre2 -> genre2.getGenre().equals(genre))
                .findAny();
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
