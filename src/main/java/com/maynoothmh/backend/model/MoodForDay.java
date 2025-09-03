package com.maynoothmh.backend.model;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection ="moodForDay")
public class MoodForDay {
	
	@Id
	private String id;
	
	private String userId;
	private String notes;
	private int moodInNum;
//	private List <Tag> tags;
	private LocalDateTime timestamp = LocalDateTime.now();

	
	public MoodForDay() {
		
	}
	
	public MoodForDay(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getMoodInNum() {
		return moodInNum;
	}
	public void setMoodInNum(int moodInNum) {
		this.moodInNum = moodInNum;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}	
	
	@Override
	public String toString() {
		
		return super.toString();
	}
}
