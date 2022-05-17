///**
// * @Author:Awadhesh
// * @Date:16-05-2022
// * @Time:23:09
// * @Project Name:project-movie-application
// */
//package com.movieapp.controller;
//
//import com.movieapp.model.AppUser;
//import com.movieapp.service.IAppUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AppUserController {
//    private IAppUserService iAppUserService;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Autowired
//    public void setiAppUserService(IAppUserService iAppUserService) {
//        this.iAppUserService = iAppUserService;
//    }
//    @PostMapping("/")
//    public void addUser(@RequestBody AppUser appUser){
//        String username = appUser.getUsername();
//        String password = appUser.getPassword();
//        String encodedPassword = passwordEncoder.encode(password);
//        AppUser user = new AppUser(username,encodedPassword);
//        iAppUserService.addAppUser(user);
//    }
//
//}
