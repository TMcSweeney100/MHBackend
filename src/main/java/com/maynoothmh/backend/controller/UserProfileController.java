package com.maynoothmh.backend.controller;

import com.maynoothmh.backend.model.UserProfile;
import com.maynoothmh.backend.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    @PostMapping
    public UserProfile createProfile(@RequestBody UserProfile profile) {
        return repository.save(profile);
    }

    @GetMapping("/{id}")
    public UserProfile getProfile(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
}
