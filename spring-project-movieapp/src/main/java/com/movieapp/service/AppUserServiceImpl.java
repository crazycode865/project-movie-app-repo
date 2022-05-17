/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:23:02
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.model.AppUser;
import com.movieapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class AppUserServiceImpl implements IAppUserService {
    IAppUserRepository iAppUserRepository;

    @Autowired
    public void setiAppUserRepository(IAppUserRepository iAppUserRepository) {
        this.iAppUserRepository = iAppUserRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser appUser = iAppUserRepository.findByUsername(username);
//        String nusername = appUser.getUsername();
//        String password = appUser.getPassword();
//        //Set Roles for user
//        GrantedAuthority authority1 = new SimpleGrantedAuthority("USER");
//        GrantedAuthority authority2 = new SimpleGrantedAuthority("ADMIN");
//        UserDetails user = new User(nusername, password, Arrays.asList(authority1, authority2));
//        return user;
//    }

    @Override
    public void addAppUser(AppUser appUser) {
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
