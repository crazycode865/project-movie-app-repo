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
     *Add show Through Theatre Controller
     * @param show Show
     */
    @Override
    public void addShow(Show show){
iShowRepository.save(show);
    }

    /**
     *
     * @param showId Show Id
     * @throws ShowNotFoundException Exception
     */
    @Override
    public void deleteShow(int showId) throws ShowNotFoundException {
iShowRepository.deleteById(showId);
    }

    /**
     *Updating Show details
     * @param show show
     */
    @Override
    public void updateShow(Show show) {
iShowRepository.save(show);
    }

    /**
     *
     * @param showId Show id
     * @return Getting show By id
     * @throws ShowNotFoundException Exception
     */
    @Override
    public Show getById(int showId)  {
        return iShowRepository.findById(showId).stream().findAny().orElseThrow(()->new ShowNotFoundException("Show not Found with this Id"));
    }

    /**
     *
     * @return Getting All Show
     */
    @Override
    public List<Show> getAll() {
        List<Show>shows = iShowRepository.findAll();
        if (shows.isEmpty())
            throw new ShowNotFoundException("Show Not Found");
        return shows;
    }
    /**
     *
     * @param showStartTime Show Start Time
     * @return Getting By Show Start Time
     * @throws ShowNotFoundException Exception
     */
    @Override
    public List<Show> getByShowStartTime(LocalDateTime showStartTime){
        List<Show> shows = iShowRepository.findByShowStartTime(showStartTime);
        if (shows.isEmpty())
            throw new ShowNotFoundException("Show not Found with this Start Time");
        return shows;
    }

    /**
     *
     * @param showEndTime Show End Time
     * @return Getting Show By End Time
     * @throws ShowNotFoundException Exception
     */
    @Override
    public List<Show> getByShowEndTime(LocalDateTime showEndTime) throws ShowNotFoundException {
        List<Show> shows = iShowRepository.getByShowEndTime(showEndTime);
        if (shows.isEmpty())
            throw new ShowNotFoundException("Show not Found with this End Time");
        return shows;
    }

    /**
     *
     * @param movieName Movie Name
     * @return Getting Show By movie
     * @throws ShowNotFoundException Exception
     */
    @Override
    public List<Show> getShowByMovie(String movieName) throws ShowNotFoundException {
       List<Show> shows = iShowRepository.getShowByMovie(movieName);
        if (shows.isEmpty())
            throw new ShowNotFoundException("Show not Found with this End Time");
        return shows;
    }

    /**
     *
     * @param price Price
     * @return Getting Show By Price
     * @throws ShowNotFoundException Exception
     */
    @Override
    public List<Show> getShowByPrice(double price) throws ShowNotFoundException {
        List<Show> shows = iShowRepository.getShowByPrice(price);
        if (shows.isEmpty())
            throw new ShowNotFoundException("Show not Found with this End Time");
        return shows;
    }


}
