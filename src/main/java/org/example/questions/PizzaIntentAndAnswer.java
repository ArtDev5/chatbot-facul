package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;

public class PizzaIntentAndAnswer implements Question {
    @Override
    public boolean verifyIntent(MessageEntity messageEntity) {
        return messageEntity.getIntent().equals("Pizza");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        return "Diga-me quais os sabores.";
    }
}
