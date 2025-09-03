package com.maynoothmh.backend.model;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aiNotes")
public class NoteAI {
	
	@Id
	private String idString;
	
	private String userIdString;
	private String text;
	private LocalDateTime timeStampDateTime = LocalDateTime.now();
	
	 public NoteAI() {
		
	}

	public String getUserIdString() {
		return userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTimeStampDateTime() {
		return timeStampDateTime;
	}

	public void setTimeStampDateTime(LocalDateTime timeStampDateTime) {
		this.timeStampDateTime = timeStampDateTime;
	}
	 
	 
		
	}

