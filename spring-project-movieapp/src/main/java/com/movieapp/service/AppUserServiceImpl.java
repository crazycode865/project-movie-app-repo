package com.movieapp.service;


import com.movieapp.model.AppUser;
import com.movieapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AppUserServiceImpl implements UserDetailsService, IAppUserService {

    private IAppUserRepository iAppUserRepository;

    @Autowired
    public void setiAppUserRepository(IAppUserRepository iAppUserRepository) {
        this.iAppUserRepository = iAppUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepository.findByUsername(username);
        String username1 = appUser.getUsername();
        String password = appUser.getPassword();
        //Set Roles for user
        GrantedAuthority authority1 = new SimpleGrantedAuthority("USER");
        GrantedAuthority authority2 = new SimpleGrantedAuthority("ADMIN");
        UserDetails user = new User(username1, password, Arrays.asList(authority1, authority2));
        return user;
    }

    @Override
    public void addUser(AppUser appUser) {
        iAppUserRepository.save(appUser);
    }

    @Override
    public void updateAppUser(AppUser appUser) {
     iAppUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUser(int userId) {
        iAppUserRepository.deleteById(userId);
    }
}
