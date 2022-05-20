package com.movieapp.repository;


import com.movieapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);

}
