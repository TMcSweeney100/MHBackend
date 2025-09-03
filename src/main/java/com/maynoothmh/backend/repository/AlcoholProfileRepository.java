package com.maynoothmh.backend.repository;

import com.maynoothmh.backend.model.AlcoholProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AlcoholProfileRepository extends MongoRepository<AlcoholProfile, String> {
    Optional<AlcoholProfile> findByUserId(String userId);
}
