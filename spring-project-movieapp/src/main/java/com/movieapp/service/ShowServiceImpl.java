/**
 * @Author:Awadhesh
 * @Date:15-05-2022
 * @Time:19:58
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.exception.ShowNotFoundException;
import com.movieapp.model.Show;
import com.movieapp.repository.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowServiceImpl implements IShowService {
    IShowRepository iShowRepository;

    @Autowired
    public void setiShowRepository(IShowRepository iShowRepository) {
        this.iShowRepository = iShowRepository;
    }

    /**
     *
     * @param show
     */
    @Override
    public void addShow(Show show){
iShowRepository.save(show);
    }

    /**
     *
     * @param showId
     * @throws ShowNotFoundException
     */
    @Override
    public void deleteShow(int showId) throws ShowNotFoundException {
iShowRepository.deleteById(showId);
    }

    /**
     *
     * @param show
     */
    @Override
    public void updateShow(Show show) {
iShowRepository.save(show);
    }

    /**
     *
     * @param showId
     * @return
     * @throws ShowNotFoundException
     */
    @Override
    public Show getById(int showId) throws ShowNotFoundException {
        return iShowRepository.findById(showId).get();
    }

    /**
     *
     * @param showStartTime
     * @return
     * @throws ShowNotFoundException
     */
    @Override
    public List<Show> getByShowStartTime(LocalDateTime showStartTime) throws ShowNotFoundException {
        return iShowRepository.findByShowStartTime(showStartTime);
    }

    @Override
    public List<Show> getAll() {
        return iShowRepository.findAll();
    }
}
