package com.example.MyProject.service;

import com.example.MyProject.domain.Genre;
import com.example.MyProject.repository.GenreRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // ジャンル登録
    public long regist(Genre genre){
        genreRepository.genreSave(genre);
        return genre.getId();
    }

    public List<Genre> findGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findOneGenre(Long GenreId) {
        return genreRepository.findById(GenreId);
    }


}
