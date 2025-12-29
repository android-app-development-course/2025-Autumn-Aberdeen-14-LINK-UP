package com.example.chatnew;

public class RecommendationItem {
    private String name;
    private int matchPercentage;
    private String tags;

    public RecommendationItem(String name, int matchPercentage, String tags) {
        this.name = name;
        this.matchPercentage = matchPercentage;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public int getMatchPercentage() {
        return matchPercentage;
    }

    public String getTags() {
        return tags;
    }
}