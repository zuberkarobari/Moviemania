package com.zuber.service;

import com.zuber.dto.MovieDTO;
import com.zuber.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO , MultipartFile file) throws IOException;

    Optional<Movie> getMovie(Integer movieId);

    List<MovieDTO> getAllMovie();


}
