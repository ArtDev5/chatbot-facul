package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;

public class AgeIntentAndAnswer implements Question {

    @Override
    public boolean verifyIntent(MessageEntity messageEntity){
        String intent = messageEntity.getIntent();

        return intent.equals("Age");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity){
        return "21 anos.";
    }
}
