package com.example.chatnew;

public class ActivityItem {
    private String name;
    private String time;
    private String location;
    private String participants;
    private int imageResource;

    public ActivityItem(String name, String time, String location, String participants, int imageResource) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.participants = participants;
        this.imageResource = imageResource;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getParticipants() {
        return participants;
    }

    public int getImageResource() {
        return imageResource;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}