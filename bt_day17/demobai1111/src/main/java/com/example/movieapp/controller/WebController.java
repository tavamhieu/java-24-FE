package com.example.movieapp.controller;

import com.example.movieapp.entity.Movie;
import com.example.movieapp.model.enums.MovieType;
import com.example.movieapp.seviice.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Import đúng lớp Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final WebService webService;

    @GetMapping
    public String getHomePage(Model model) {
        return "web/index";
    }

    // http://localhost:8080/phim-bo
    // http://localhost:8080/phim-bo?page=1&limit=12
    @GetMapping("/phim_bo")
    public String getPhimBoPage(Model model,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "12") Integer limit) {

        Page<Movie> pageData = webService.findByType(MovieType.PHIM_BO, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim_bo";
    }

    @GetMapping("/phim_le")
    public String getPhimLePage(Model model,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "12") Integer limit) {
        Page<Movie> pageData = webService.findByType(MovieType.PHIM_LE, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim_le";
    }

    @GetMapping("/phim_chieu_rap")
    public String getPhimChieuRapPage(Model model,
                                      @RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "12") Integer limit) {
        Page<Movie> pageData = webService.findByType(MovieType.PHIM_CHIEU_RAP, true, page, limit);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim_chieu_rap";
    }

    @GetMapping("/phim/{id}/{slug}")
    public String getMovieDetailsPage(@PathVariable Integer id,
                                      @PathVariable String slug,
                                      Model model) {
        return "web/chi_tiet_phim";
    }
}
