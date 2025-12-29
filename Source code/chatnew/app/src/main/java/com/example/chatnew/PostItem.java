package com.example.chatnew;

public class PostItem {
    private String author;
    private String time;
    private String content;
    private int imageResource;
    private int likes;
    private int comments;
    private int shares;

    public PostItem(String author, String time, String content, int imageResource, int likes, int comments, int shares) {
        this.author = author;
        this.time = time;
        this.content = content;
        this.imageResource = imageResource;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getShares() {
        return shares;
    }

    // Setters
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }
}