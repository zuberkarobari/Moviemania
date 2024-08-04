package com.zuber.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuber.dto.MovieDTO;
import com.zuber.entity.Movie;
import com.zuber.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Endpoint to add a new movie
    @PostMapping("/add")
    public ResponseEntity<MovieDTO> addMovie(@RequestParam("file") MultipartFile file,
                                             @RequestPart String movieDto) {
        try {
            MovieDTO movieDtoObj=convertStringTODTO(movieDto);
            MovieDTO savedMovieDto = movieService.addMovie(movieDtoObj, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovieDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    MovieDTO convertStringTODTO(String content) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(content,MovieDTO.class);
    }
    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable Integer movieId) {
        Optional<Movie> movieDto = movieService.getMovie(movieId);
        if (movieDto != null) {
            return ResponseEntity.ok(movieDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movieList = movieService.getAllMovie();
        return ResponseEntity.ok(movieList);
    }
}

