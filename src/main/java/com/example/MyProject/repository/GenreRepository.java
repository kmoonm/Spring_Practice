package com.example.MyProject.repository;

import com.example.MyProject.domain.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    Genre genreSave(Genre genre);

    Optional<Genre> findById(Long id);

    Optional<Genre> findByName(String genre);

    List<Genre> findAll();


}
