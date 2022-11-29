package org.example.entities;

public class BotResponse {
    String answer;

    public BotResponse() {
    }

    public BotResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "BotResponse{" +
                "answer='" + answer + '\'' +
                '}';
    }
}


