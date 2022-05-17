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
    public Movie addMovie(Movie movie) throws MovieNotFoundException {
        return iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     * @throws MovieNotFoundException
     */
    @Override
    public void deleteMovie(int movieId) throws MovieNotFoundException {
        iMovieRepository.deleteById(movieId);
    }

    /**
     *
     * @param movie
     * @throws MovieNotFoundException
     */
    @Override
    public void updateMovie(Movie movie) throws MovieNotFoundException {
        iMovieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Movie getById(int movieId) throws MovieNotFoundException {
        return iMovieRepository.findById(movieId).get();
    }

    /**
     *
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getAll() throws MovieNotFoundException {
        return iMovieRepository.findAll();
    }

    /**
     *
     * @param movieName
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Movie getByMovieName(String movieName) throws MovieNotFoundException {
        return iMovieRepository.findByMovieName(movieName);
    }

    /**
     *
     * @param language
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByLanguage(String language) throws MovieNotFoundException {
        return iMovieRepository.findByLanguage(language);
    }

    /**
     *
     * @param genre
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByGenre(String genre) throws MovieNotFoundException {
        return iMovieRepository.findByGenre(genre);
    }

    /**
     *
     * @param type
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByType(String type) throws MovieNotFoundException {
        return iMovieRepository.findByType(type);
    }

    /**
     *
     * @param ratings
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByRatings(double ratings) throws MovieNotFoundException {
        return iMovieRepository.findByRatings(ratings);
    }

    /**
     *
     * @param movieName
     * @param ratings
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieNameAndRatings(String movieName, double ratings) throws MovieNotFoundException {
        return iMovieRepository.findByMovieNameAndRatings(movieName,ratings);
    }

    /**
     *
     * @param language
     * @param type
     * @return
     */
    @Override
    public List<Movie> getByLanguageAndType(String language, String type) {
        return iMovieRepository.findByLanguageAndType(language,type);
    }
}
