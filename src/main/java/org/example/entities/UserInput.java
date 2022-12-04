package org.example.entities;

public class UserInput {
    String userId;
    String userMessage;

    public UserInput() {
    }

    public UserInput(String userId, String userMessage) {
        this.userId = userId;
        this.userMessage = userMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
