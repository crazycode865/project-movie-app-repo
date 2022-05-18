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
     * @param movie
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Movie addMovie(Movie movie) {
        return iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     * @throws MovieNotFoundException
     */
    @Override
    public void deleteMovie(int movieId) {
        iMovieRepository.deleteById(movieId);
    }

    /**
     *
     * @param movie
     * @throws MovieNotFoundException
     */
    @Override
    public void updateMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Movie getById(int movieId) {
        return iMovieRepository.findById(movieId).stream().findAny().orElseThrow(()->new MovieNotFoundException("Movie not Found By Id"));
    }

    /**
     *
     * @return
     * @throws MovieNotFoundException
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
     * @param movieName
     * @return
     * @throws MovieNotFoundException
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
     * @param language
     * @return
     * @throws MovieNotFoundException
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
     * @param genre
     * @return
     * @throws MovieNotFoundException
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
     * @param type
     * @return
     * @throws MovieNotFoundException
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
     * @param ratings
     * @return
     * @throws MovieNotFoundException
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
     * @param movieName
     * @param ratings
     * @return
     * @throws MovieNotFoundException
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
     * @param language
     * @param type
     * @return
     */
    @Override
    public List<Movie> getByLanguageAndType(String language, String type) {
        List<Movie> movies =  iMovieRepository.findByLanguageAndType(language,type);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie Not Found with this language and Type");
        return movies;
    }
}
