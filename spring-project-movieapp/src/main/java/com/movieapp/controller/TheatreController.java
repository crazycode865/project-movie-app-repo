/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:10:29
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.Show;
import com.movieapp.model.Theatre;
import com.movieapp.service.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre-api")
public class TheatreController {
    ITheatreService iTheatreService;

    @Autowired
    public void setiTheatreService(ITheatreService iTheatreService) {
        this.iTheatreService = iTheatreService;
    }
    @PostMapping("/theatres/add-theatre")
    public ResponseEntity<Void> addTheatre(@RequestBody Theatre theatre){
        iTheatreService.addTheatre(theatre);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @PutMapping("/theatres/update-theatre")
    public ResponseEntity<Void> updateTheatre(@RequestBody Theatre theatre){
        iTheatreService.updateTheatre(theatre);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @DeleteMapping("/theatres/delete-theatre/theatreId/{theatreId}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable("theatreId")int theatreId){
        iTheatreService.deleteTheatre(theatreId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Delete theatre By Id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }
    @GetMapping("/theatres/theatreId/{theatreId}")
    public ResponseEntity<Theatre> getById(@PathVariable("theatreId")int theatreId) throws TheatreNotFoundException {
    Theatre theatre = iTheatreService.getById(theatreId);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("desc","Getting By Theatre Id");
    ResponseEntity<Theatre> responseEntity = new ResponseEntity<>(theatre,httpHeaders,HttpStatus.OK);
    return responseEntity;
    }
    @GetMapping("/theatres/showAll")
    public ResponseEntity<List<Theatre>> getAll() throws MovieNotFoundException {
        List<Theatre> theatres = iTheatreService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting all Theatres");
        ResponseEntity<List<Theatre>> responseEntity = new ResponseEntity<>(theatres, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("theatres/theatreName/{theatreName}")
    public ResponseEntity<Theatre> getByTheatreName(@PathVariable("theatreName")String theatreName) throws TheatreNotFoundException {
        Theatre theatre = iTheatreService.getByTheatreName(theatreName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting By Theatre Name");
        ResponseEntity<Theatre> responseEntity = new ResponseEntity<>(theatre,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/theatres/city/{city}")
    public ResponseEntity<List<Theatre>> getByCity(@PathVariable("city")String city) throws TheatreNotFoundException {
        List<Theatre> theatres  = iTheatreService.getByCity(city);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting Theatre By city");
        ResponseEntity<List<Theatre>> responseEntity = new ResponseEntity<>(theatres,httpHeaders,HttpStatus.OK);
        return responseEntity;
    }
}
