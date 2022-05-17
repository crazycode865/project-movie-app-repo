package com.movieapp.service;

import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.Theatre;

import java.util.List;

public interface ITheatreService {
    public void  addTheatre(Theatre theatre);
    public void updateTheatre(Theatre theatre);
    public void deleteTheatre(int theatreId);
    public Theatre getById(int theatreId)throws TheatreNotFoundException;
    public Theatre getByTheatreName(String theatreName)throws TheatreNotFoundException;
    public List<Theatre> getByCity(String city)throws TheatreNotFoundException;

    List<Theatre> getAll();
}
