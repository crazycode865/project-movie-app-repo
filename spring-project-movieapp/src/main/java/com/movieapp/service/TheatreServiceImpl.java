/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:10:15
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.exception.TheatreNotFoundException;
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

        return iTheatreRepository.findById(theatreId).stream().findAny(). orElseThrow(()->new TheatreNotFoundException("Theatre not Found with this id")) ;

    }

    /**
     *
     * @param theatreName
     * @return
     */
    @Override
    public Theatre getByTheatreName(String theatreName) {

        Theatre theatre =   iTheatreRepository.findByTheatreName(theatreName);
        if(theatre==null)
            throw new TheatreNotFoundException("Theatre not Found By this Theatre Name");
        return theatre;
    }

    /**
     *
     * @param city
     * @return
     */
    @Override
    public List<Theatre> getByCity(String city) {

        List<Theatre> theatres= iTheatreRepository.findByCity(city);
        if(theatres.isEmpty())
            throw new TheatreNotFoundException("Theatre not found with this city");
        return theatres;
    }

    @Override
    public List<Theatre> getAll() {
        List<Theatre> theatres = iTheatreRepository.findAll();
        if (theatres.isEmpty())
            throw new TheatreNotFoundException("Theatre not Found");
        return theatres;
    }
}
