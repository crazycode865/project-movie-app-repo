/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:10:15
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.model.Theatre;
import com.movieapp.repository.ITheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TheatreServiceImpl implements ITheatreService {
    ITheatreRepository iTheatreRepository;
    @Autowired
    public void setiTheatreRepository(ITheatreRepository iTheatreRepository) {
        this.iTheatreRepository = iTheatreRepository;
    }

    /**
     *
     * @param theatre
     */
    @Override
    public void addTheatre(Theatre theatre) {
        iTheatreRepository.save(theatre);
    }

    /**
     *
     * @param theatre
     */
    @Override
    public void updateTheatre(Theatre theatre) {
        iTheatreRepository.save(theatre);
    }

    /**
     *
     * @param theatreId
     */
    @Override
    public void deleteTheatre(int theatreId) {
        iTheatreRepository.deleteById(theatreId);
    }

    /**
     *
     * @param theatreId
     * @return
     */
    @Override
    public Theatre getById(int theatreId) {

        return iTheatreRepository.findById(theatreId).get();
    }

    /**
     *
     * @param theatreName
     * @return
     */
    @Override
    public Theatre getByTheatreName(String theatreName) {
        return iTheatreRepository.findByTheatreName(theatreName);
    }

    /**
     *
     * @param city
     * @return
     */
    @Override
    public List<Theatre> getByCity(String city) {
        return iTheatreRepository.findByCity(city);
    }

    @Override
    public List<Theatre> getAll() {
        return iTheatreRepository.findAll();
    }
}
