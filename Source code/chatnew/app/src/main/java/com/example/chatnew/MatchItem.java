package com.example.chatnew;

public class MatchItem {
    private String name;
    private int matchPercentage;
    private String tag;
    private String reason;
    private int avatarResource;

    public MatchItem(String name, int matchPercentage, String tag, String reason, int avatarResource) {
        this.name = name;
        this.matchPercentage = matchPercentage;
        this.tag = tag;
        this.reason = reason;
        this.avatarResource = avatarResource;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMatchPercentage() {
        return matchPercentage;
    }

    public String getTag() {
        return tag;
    }

    public String getReason() {
        return reason;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMatchPercentage(int matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }
}