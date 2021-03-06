package com.movieapp.repository;

import com.movieapp.exception.ShowNotFoundException;
import com.movieapp.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IShowRepository extends JpaRepository<Show, Integer> {

    public List<Show> findByShowStartTime(LocalDateTime showStartTime) throws ShowNotFoundException;

    public List<Show> getByShowEndTime(LocalDateTime showEndTime) throws ShowNotFoundException;

    List<Show> getShowByMovie(String movieName) throws ShowNotFoundException;

    List<Show> getShowByPrice(double price)throws ShowNotFoundException;



}
