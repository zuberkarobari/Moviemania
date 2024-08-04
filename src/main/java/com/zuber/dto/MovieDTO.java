package com.zuber.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class MovieDTO {

    private Long movieId;
    private String title;
    private String director;
    private String studio;
    private List<String> cast;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the releasing year for this movie")
    private int releaseYear;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the poster URL")
    private String posterUrl;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the poster !!!!")
    private String poster;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the length  of the movie")
    private int runtimeMinutes;
    private double rating;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the Genre of this movie")
    private String genre;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the Language of this movie")
    private String language;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    // Constructors, Getters, Setters, and other methods

    public MovieDTO() {
    }

    public MovieDTO(Long movieId, String title, String director, String studio, List<String> cast, int releaseYear, String posterUrl, int runtimeMinutes, double rating, String genre, String language, String synopsis, String poster) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.cast = cast;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.runtimeMinutes = runtimeMinutes;
        this.rating = rating;
        this.genre = genre;
        this.language = language;
        this.synopsis = synopsis;
        this.poster = poster;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
