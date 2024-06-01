package com.example.movieapp.seviice;


import com.example.movieapp.MovieAppApplication;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.model.enums.MovieType;
import com.example.movieapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebService {
    private  final  MovieRepository movieRepository;


    public Page<Movie> findByType(MovieType type, boolean status, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page-1,limit,Sort.by("publishedAt").descending());
        return movieRepository. findByTypeAndStatus(type,status,pageable);
    }
}