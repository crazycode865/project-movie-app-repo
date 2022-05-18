package com.movieapp.repository;

import com.movieapp.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITheatreRepository extends JpaRepository<Theatre,Integer> {


    //Derived query
    @Query("from Theatre t where t.theatreName=?1")
    public Theatre findByTheatreName(String theatreName);
    @Query("from Theatre t inner join t.address a where a.city=?1")
    public List<Theatre> findByCity(String city);
}
