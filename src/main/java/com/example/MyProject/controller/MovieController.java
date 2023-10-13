package com.example.MyProject.controller;

import com.example.MyProject.domain.Genre;
import com.example.MyProject.service.GenreService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    private final GenreService genreService;

    public MovieController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping("/")
    public String movieHome() {
        return "movieHome";
    }

    @RequestMapping("/genre")
    public String movieGenre(Model model) {
        // List<Genre> genres =
        return "movieGenre";
    }

    @RequestMapping("/genre/movieList")
    public String movieList(Model model) {
        return null;
    }

    @RequestMapping("/genre/new")
    public String createGenreForm() {
        return "members/movieGenreRegistForm";
    }
    @PostMapping("/genre/new")
    public String createGenre(@NotNull GenreForm genreForm) {
        Genre genre = new Genre();
        genre.setGenre(genreForm.getGenreName());
        genreService.regist(genre);

        return "redirect:/";
    }
}
