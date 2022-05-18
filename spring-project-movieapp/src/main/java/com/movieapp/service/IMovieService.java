package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

import java.time.LocalDate;
import java.util.List;


public interface IMovieService {
    public Movie addMovie(Movie movie) ;

    public void deleteMovie(int movieId) ;

    public void updateMovie(Movie movie) ;

    Movie getById(int movieId) throws MovieNotFoundException;

    List<Movie> getAll() throws MovieNotFoundException;

    Movie getByMovieName(String movieName) throws MovieNotFoundException;

    List<Movie> getByLanguage(String language) throws MovieNotFoundException;
    List<Movie> getByGenre(String genre) throws MovieNotFoundException;
    List<Movie> getByType(String type) throws MovieNotFoundException;
    List<Movie> getByRatings(double ratings) throws MovieNotFoundException;
    List<Movie> getByMovieNameAndRatings(String movieName,double ratings)throws  MovieNotFoundException;
    List<Movie> getByLanguageAndType(String language,String type);

}
