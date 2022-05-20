package com.movieapp.controller;


import com.movieapp.model.AppUser;
import com.movieapp.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserController {
    private IAppUserService iAppUserService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setiAppUserService(IAppUserService iAppUserService) {
        this.iAppUserService = iAppUserService;
    }

    @PostMapping("/")
    public void addUser(@RequestBody AppUser appUser) {
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username, encodedPassword);
        iAppUserService.addUser(user);
    }

    @DeleteMapping("/userId/{userId}")
    public void deleteUser(@PathVariable("userId")int userId) {

        iAppUserService.deleteAppUser(userId);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody AppUser appUser) {
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username, encodedPassword);
        iAppUserService.updateAppUser(user);
    }
}
