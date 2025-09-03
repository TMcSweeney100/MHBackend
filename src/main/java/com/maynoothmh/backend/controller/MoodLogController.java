package com.maynoothmh.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.maynoothmh.backend.model.MoodForDay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.savedrequest.SavedCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maynoothmh.backend.model.MoodForDay;
import com.maynoothmh.backend.model.Routine;
import com.maynoothmh.backend.model.Tag;
import com.maynoothmh.backend.model.Task;
import com.maynoothmh.backend.repository.MoodForDayRepository;

@RestController
@RequestMapping("/moodLog")


public class MoodLogController {
	
	@Autowired
	MoodForDayRepository moodForDayRepository;
	
	@PostMapping
	public ResponseEntity<MoodForDay> saveOrUpdateMoodForDay(@RequestBody MoodForDay moodForDay){
		
		MoodForDay moodToSave = new MoodForDay();
		
		if(moodForDay != null) {
			moodToSave.setMoodInNum(moodForDay.getMoodInNum());
			moodToSave.setNotes(moodForDay.getNotes());
			moodToSave.setTimestamp(moodForDay.getTimestamp());
			moodToSave.setUserId(moodForDay.getUserId());
			
		}
		
		MoodForDay saved = moodForDayRepository.save( moodToSave);
		return ResponseEntity.ok(saved);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<MoodForDay>> getMoodLogByUser(@PathVariable String userId) {
	    List<MoodForDay> logs = moodForDayRepository.findByUserId(userId);
	    return ResponseEntity.ok(logs);
	}
	
	
	
	

}
