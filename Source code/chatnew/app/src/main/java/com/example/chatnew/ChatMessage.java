package com.example.chatnew;

public class ChatMessage {
    private String sender;
    private String message;
    private boolean isFromPartner;

    public ChatMessage(String sender, String message, boolean isFromPartner) {
        this.sender = sender;
        this.message = message;
        this.isFromPartner = isFromPartner;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public boolean isFromPartner() {
        return isFromPartner;
    }
}