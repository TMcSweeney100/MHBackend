package com.maynoothmh.backend.controller;

import com.maynoothmh.backend.model.AlcoholProfile;
import com.maynoothmh.backend.repository.AlcoholProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;


@RestController
@RequestMapping("/alcohol")
@CrossOrigin(origins = "http://localhost:5173")
public class AlcoholProfileController {

    @Autowired
    private AlcoholProfileRepository repository;

    @PostMapping("/profile")
    public ResponseEntity<AlcoholProfile> saveProfile(@RequestBody AlcoholProfile incoming) {
        Optional<AlcoholProfile> existingOpt = repository.findByUserId(incoming.getUserId());

        if (existingOpt.isPresent()) {
            AlcoholProfile existing = existingOpt.get();
            // ✅ preserve _id so we UPDATE, not INSERT
            incoming.setId(existing.getId());
            // keep original createdAt if client didn’t send one
            if (incoming.getCreatedAt() == null) {
                incoming.setCreatedAt(existing.getCreatedAt());
            }
        } else {
            if (incoming.getCreatedAt() == null) {
                incoming.setCreatedAt(Instant.now().toString());
            }
        }

        AlcoholProfile saved = repository.save(incoming);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<AlcoholProfile> getProfile(@PathVariable String userId) {
        return repository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}