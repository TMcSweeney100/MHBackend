package com.maynoothmh.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maynoothmh.backend.model.MoodForDay;

@Repository
public interface MoodForDayRepository extends MongoRepository<MoodForDay, String> {
	

	
	 List<MoodForDay> findByUserId(String userId);
	
}
