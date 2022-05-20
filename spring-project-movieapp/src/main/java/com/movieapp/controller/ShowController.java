/**
 * @Author:Awadhesh
 * @Date:15-05-2022
 * @Time:20:09
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.exception.ShowNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.model.Show;
import com.movieapp.service.IShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/show-api")
public class ShowController {
    IShowService iShowService;

    @Autowired
    public void setiShowService(IShowService iShowService) {
        this.iShowService = iShowService;
    }

    /**
     *
     * @param show
     * @return No Need of Adding Show through Show Controller ,Show Should be Added through Theatre Controller
     */
//    @PostMapping("/shows/add-show")
//    public ResponseEntity<Void> addshow(@RequestBody Show show) {
//        iShowService.addShow(show);
//        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
//        return responseEntity;
//    }

    @PutMapping("/admin/shows/update-show")
    public ResponseEntity<Void> updateShow(@RequestBody Show show) {
        iShowService.updateShow(show);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    @DeleteMapping("/admin/shows/delete-show/showId/{showId}")
    public ResponseEntity<Void> deleteShow(@PathVariable("showId") int showId) {
        iShowService.deleteShow(showId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Deleting show By Id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }

    @GetMapping("admin/shows/showId/{showId}")
    public ResponseEntity<Show> getById(@PathVariable("movieId") int showId)  {
        Show show = iShowService.getById(showId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting show By Id");
        ResponseEntity<Show> responseEntity = new ResponseEntity<>(show, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/shows/showAll")
    public ResponseEntity<List<Show>> getall()  {

        List<Show> shows = iShowService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting all shows");
        ResponseEntity<List<Show>> responseEntity = new ResponseEntity<>(shows, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/shows/showStartTime/{showStartTime}")
    public ResponseEntity<List<Show>> getByShowStartTime(@PathVariable("showStartTime") String showStartTime){
        LocalDateTime startTime = LocalDateTime.parse(showStartTime);
        List<Show> shows = iShowService.getByShowStartTime(startTime);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Get Show By Start Time");
        ResponseEntity<List<Show>> responseEntity = new ResponseEntity<>(shows, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/shows/showEndTime/{showEndTime}")
    public ResponseEntity<List<Show>> getByShowEndTime(@PathVariable("showEndTime") String showEndTime){
        LocalDateTime endTime = LocalDateTime.parse(showEndTime);
        List<Show> shows = iShowService.getByShowEndTime(endTime);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Get Show By End Time");
        ResponseEntity<List<Show>> responseEntity = new ResponseEntity<>(shows, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/shows/movieName/{movieName}")
    public ResponseEntity<List<Show>> getShowByMovie(@PathVariable("movieName") String movieName){
        List<Show> shows = iShowService.getShowByMovie(movieName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Get Show By Movie");
        ResponseEntity<List<Show>> responseEntity = new ResponseEntity<>(shows, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/shows/price/{price}")
    public ResponseEntity<List<Show>> getShowByPrice(@PathVariable("price") double price){
        List<Show> shows = iShowService.getShowByPrice(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Get Show By Price");
        ResponseEntity<List<Show>> responseEntity = new ResponseEntity<>(shows, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }



}
