package com.movieapp.service;

import com.movieapp.exception.ShowNotFoundException;
import com.movieapp.model.Show;

import java.time.LocalDateTime;
import java.util.List;

public interface IShowService {
    public void addShow(Show show);
    public void updateShow(Show show);
    public void deleteShow(int showId)throws ShowNotFoundException;
    public Show getById(int showId)throws ShowNotFoundException;
    public List<Show> getByShowStartTime(LocalDateTime showStartTime)throws ShowNotFoundException;
    public List<Show> getAll();


}
