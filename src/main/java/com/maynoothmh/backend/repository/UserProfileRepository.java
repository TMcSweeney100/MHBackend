package com.maynoothmh.backend.repository;

import com.maynoothmh.backend.model.Routine;
import com.maynoothmh.backend.model.UserProfile;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
	 Optional<UserProfile> findById(String userId);
}
