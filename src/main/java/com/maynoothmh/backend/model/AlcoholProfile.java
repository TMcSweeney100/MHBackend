package com.maynoothmh.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alcohol_profiles")
public class AlcoholProfile {
    @Id
    private String id;

    private String userId;
    private String why;
    private String positives;
    private String who;        // your FE sends `who`
    private int targetDays;
    private String createdAt;  // ISO-8601 ok
    private String startDate;  // "YYYY-MM-DD"

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getWhy() { return why; }
    public void setWhy(String why) { this.why = why; }

    public String getPositives() { return positives; }
    public void setPositives(String positives) { this.positives = positives; }

    public String getWho() { return who; }
    public void setWho(String who) { this.who = who; }

    public int getTargetDays() { return targetDays; }
    public void setTargetDays(int targetDays) { this.targetDays = targetDays; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getStartDate() { return startDate; }                 // ✅
    public void setStartDate(String startDate) { this.startDate = startDate; } // ✅
}
