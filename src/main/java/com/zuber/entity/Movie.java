package com.zuber.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;


import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @Column(nullable = false,length = 20)
    private String title;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the Director of this movie")
    private String director;
    @Column(nullable = false,length = 20)
    @NotBlank(message = "please provide the studio details")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "cast_member")
    private List<String> cast;
    private int releaseYear;
    private String posterUrl;
    private int runtimeMinutes;
    private double rating;
    private String genre;
    private String language;
    private String synopsis;
    private String poster;
    public Movie() {
    }

    public Movie(Long movieId, String title, String director, String studio, List<String> cast, int releaseYear, String posterUrl, String poster, int runtimeMinutes, double rating, String genre, String language, String synopsis) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.cast = cast;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.poster = poster;
        this.runtimeMinutes = runtimeMinutes;
        this.rating = rating;
        this.genre = genre;
        this.language = language;
        this.synopsis = synopsis;
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
