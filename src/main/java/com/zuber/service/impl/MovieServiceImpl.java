package com.zuber.service.impl;

import com.zuber.dto.MovieDTO;
import com.zuber.entity.Movie;
import com.zuber.repository.MovieRepository;
import com.zuber.service.FileService;
import com.zuber.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private FileService fileService;
    @Value("${project.poster}")
    private String uploadPath;
    @Value("${base.url}")
    private String baseUrl;
    @Override
    public MovieDTO addMovie(MovieDTO movieDto, MultipartFile file) throws IOException {
        String uploadedFileName=fileService.uploadFile(uploadPath,file);
        movieDto.setPoster(uploadedFileName);

        Movie movie=convertDtoToMovie(movieDto);
        movieRepository.save(movie);
        String fileurl="/file/";
        String posterUrl=baseUrl + fileurl + uploadedFileName;

        MovieDTO movieDTO=convertMovieToDto(movie,posterUrl);
        return movieDTO;
    }

    @Override
    public Optional<Movie> getMovie(Integer movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public List<MovieDTO> getAllMovie() {
        List<Movie> movieList= movieRepository.findAll();
        List<MovieDTO> movieDTOList=new ArrayList<>();
        String fileurl="/file/";
        movieList.stream().forEach(
                m->{
                    String posterUrl=baseUrl + fileurl + m.getPoster();
                    MovieDTO movieDTO=convertMovieToDto(m,posterUrl);
                    movieDTOList.add(movieDTO);
                }
        );
        return movieDTOList;
    }
    private Movie convertDtoToMovie(MovieDTO movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setStudio(movieDto.getStudio());
        movie.setCast(movieDto.getCast());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setPoster(movieDto.getPoster());
        movie.setPosterUrl(movie.getPosterUrl());
        movie.setRuntimeMinutes(movieDto.getRuntimeMinutes());
        movie.setRating(movieDto.getRating());
        movie.setGenre(movieDto.getGenre());
        movie.setLanguage(movieDto.getLanguage());
        movie.setSynopsis(movieDto.getSynopsis());
        return movie;
    }
    private MovieDTO convertMovieToDto(Movie movie, String posterUrl) {
        MovieDTO movieDto = new MovieDTO();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setStudio(movie.getStudio());
        movieDto.setCast(movie.getCast());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setPoster(movie.getPoster());
        movieDto.setPosterUrl(posterUrl);
        movieDto.setRuntimeMinutes(movie.getRuntimeMinutes());
        movieDto.setRating(movie.getRating());
        movieDto.setGenre(movie.getGenre());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setSynopsis(movie.getSynopsis());
        return movieDto;
    }
}
