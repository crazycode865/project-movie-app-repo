/**
 * @Author:Awadhesh Date:14-05-2022
 * Time:22:29
 * Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class MovieServiceImpl implements IMovieService{
    IMovieRepository iMovieRepository;
@Autowired
    public void setiMovieRepository(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    /**
     *
     * Add movie through Show Controller
     *
     */
    @Override
    public Movie addMovie(Movie movie) {
        return iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     * @throws MovieNotFoundException Exception
     */
    @Override
    public void deleteMovie(int movieId) {
        iMovieRepository.deleteById(movieId);
    }

    /**
     *
     * @param movie Movie Object
     *  Updating movie details
     *
     */
    @Override
    public void updateMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId Movie id
     * @return Getting By Movie Id
     * @throws MovieNotFoundException Exception
     */
    @Override
    public Movie getById(int movieId) {
        return iMovieRepository.findById(movieId).stream().findAny().orElseThrow(()->new MovieNotFoundException("Movie not Found By Id"));
    }

    /**
     *
     * @return Getting All Movie
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getAll()  {
        List<Movie> movies = iMovieRepository.findAll();
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this name and ratings");
        return movies;
    }

    /**
     *
     * @param movieName Name
     * @return Getting movie By movie name
     * @throws MovieNotFoundException Exception
     */
    @Override
    public Movie getByMovieName(String movieName) {
       Movie movie = iMovieRepository.findByMovieName(movieName);
       if (movie!=null)
           return movie;
       throw new MovieNotFoundException("Movie not Found By this Name");

    }

    /**
     *
     * @param language Language
     * @return Getting movie By language
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getByLanguage(String language)  {
        List<Movie> movies = iMovieRepository.findByLanguage(language);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this name and ratings");
        return movies;
    }

    /**
     *
     * @param genre Genre
     * @return Getting By Genre
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getByGenre(String genre) {
        List<Movie> movies =iMovieRepository.findByGenre(genre);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this name and ratings");
        return movies;
    }

    /**
     *
     * @param type type
     * @return Getting movie By Type (Hollywood, Bollywood)
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getByType(String type) {
        List<Movie> movies =iMovieRepository.findByType(type);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this name and ratings");
        return movies;
    }

    /**
     *
     * @param ratings ratings
     * @return Getting Movie By ratings
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getByRatings(double ratings) {
        List<Movie> movies = iMovieRepository.findByRatings(ratings);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this ratings");
        return movies;
    }

    /**
     *
     * @param movieName Name
     * @param ratings ratings
     * @return Getting By Movie name and ratings
     * @throws MovieNotFoundException Exception
     */
    @Override
    public List<Movie> getByMovieNameAndRatings(String movieName, double ratings) {
        List<Movie> movies = iMovieRepository.findByMovieNameAndRatings(movieName,ratings);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this name and ratings");
        return movies;
    }

    /**
     *
     * @param language language
     * @param type type
     * @return Getting By language and Type
     */
    @Override
    public List<Movie> getByLanguageAndType(String language, String type) {
        List<Movie> movies =  iMovieRepository.findByLanguageAndType(language,type);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this language and Type");
        return movies;
    }
}
