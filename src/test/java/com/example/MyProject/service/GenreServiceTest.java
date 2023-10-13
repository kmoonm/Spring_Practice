package com.example.MyProject.service;

import com.example.MyProject.domain.Genre;
import com.example.MyProject.repository.MemoryGenreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenreServiceTest {
    GenreService genreService;
    MemoryGenreRepository memoryGenreRepository;

    @BeforeEach
    public void beforeEach() {
        memoryGenreRepository = new MemoryGenreRepository();
        genreService = new GenreService(memoryGenreRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryGenreRepository.clearStore();
    }

    @Test
    void registGenre() {
        // given
        Genre genre = new Genre();
        genre.setGenre("Romance");

        // when
        Long saveId = genreService.regist(genre);

        // then
        Genre findGenre = genreService.findOneGenre(saveId).get();
        assertThat(genre.getGenre().equals(findGenre.getGenre()));

    }
}
