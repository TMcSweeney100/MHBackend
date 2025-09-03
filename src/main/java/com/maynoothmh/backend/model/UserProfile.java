package com.maynoothmh.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_profiles")
public class UserProfile {
    @Id
    private String id; // Firebase UID

    private String email;
    private String displayName;
    private int targetDays;
    private String username;

    
    // Add more fields as needed

    public UserProfile() {}

    public UserProfile(String id, String email, String displayName, int targetDays) {
        this.id = id;
        this.setEmail(email);
        this.setDisplayName(displayName);
        this.setTargetDays(targetDays);
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getTargetDays() {
		return targetDays;
	}

	public void setTargetDays(int targetDays) {
		this.targetDays = targetDays;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    // Getters and setters
}
