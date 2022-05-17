/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:22:30
 * Project Name:project-movie-application
 */
package com.movieapp.repository;

import com.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository  extends JpaRepository<Movie,Integer> {
    Movie findByMovieName(String movieName) ;

    List<Movie> findByLanguage(String language) ;
    List<Movie> findByGenre(String genre) ;
    List<Movie> findByType(String type) ;
    List<Movie> findByRatings(double ratings) ;
    List<Movie> findByMovieNameAndRatings(String movieName,double ratings);
    List<Movie> findByLanguageAndType(String language,String type);
}
