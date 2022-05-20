package com.movieapp.service;


import com.movieapp.model.AppUser;

public interface IAppUserService {
    void addUser(AppUser appUser);
    void updateAppUser(AppUser appUser);
    void deleteAppUser(int userId);

}
