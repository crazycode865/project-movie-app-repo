/**
 * @Author:Awadhesh
 * @Date:14-05-2022
 * @Time:22:53
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie-api")
public class MovieController {
    private IMovieService iMovieService;
    @Autowired
    public void setiMovieService(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    /**
     * No need to add movie separately add movie through Theatre controller only
     * @param movie
     * @return
     * @throws MovieNotFoundException
     */
//    @PostMapping("/movies/add-movie")
//    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws MovieNotFoundException {
//        iMovieService.addMovie(movie);
//        ResponseEntity<Movie> responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(movie);
////        System.out.println("Adding movies");
//        return responseEntity;
//    }
    @PutMapping("/movies/update-movie")
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movie) throws MovieNotFoundException {
        iMovieService.updateMovie(movie);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
       // System.out.println("Updating movies");
        return responseEntity;
    }
    @DeleteMapping("/movies/delete-movie/movieId/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieId")int movieId) throws MovieNotFoundException {
        iMovieService.deleteMovie(movieId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Deleting movie By Id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }
    @GetMapping("/movies/showAll")
    public ResponseEntity<List<Movie>> getall() throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting all movies");
        ResponseEntity<List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/movieName/{movieName}")
    public ResponseEntity<Movie> getByMovieName(@PathVariable("movieName")String movieName) throws MovieNotFoundException {
        Movie movie = iMovieService.getByMovieName(movieName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by Name");
        ResponseEntity <Movie> responseEntity = new ResponseEntity<>(movie, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/language/{language}")
    public ResponseEntity<List<Movie>> getByMovieLanguage(@PathVariable("language")String language) throws MovieNotFoundException {
       List<Movie> movies = iMovieService.getByLanguage(language);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by language");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable("genre")String genre) throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getByGenre(genre);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by genre");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/movies/type/{type}")
    public ResponseEntity<List<Movie>> getByType(@PathVariable("type")String type) throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getByType(type);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by Type");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/ratings/{ratings}")
    public ResponseEntity<List<Movie>> getByRatings(@PathVariable("ratings")double ratings) throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getByRatings(ratings);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by ratings");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/movieName/{movieName}/ratings/{ratings}")
    public ResponseEntity<List<Movie>> getByMovieNameAndRatings(@PathVariable(
            "movieName")String movieName,@PathVariable("ratings")double ratings) throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getByMovieNameAndRatings(movieName,ratings);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by double");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/movies/language/{language}/type/{type}")
    public ResponseEntity<List<Movie>> getByLanguageAndType(@PathVariable("language")String language,@PathVariable("type")String type) throws MovieNotFoundException {
        List<Movie> movies = iMovieService.getByLanguageAndType(language,type);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting movies by language and Type ");
        ResponseEntity <List<Movie>> responseEntity = new ResponseEntity<>(movies, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping("/greet")
    public String greet() {
        return "This is movie Controller";
    }

    @GetMapping("/show")
    public String show() {
        return "Welcome to movie application";
    }
}
