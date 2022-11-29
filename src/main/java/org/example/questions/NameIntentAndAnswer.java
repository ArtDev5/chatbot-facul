package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;

public class NameIntentAndAnswer implements Question {

    @Override
    public boolean verifyIntent(MessageEntity messageEntity){
        String intent = messageEntity.getIntent();

        return intent.equals("Name");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        return "Artur Silva.";
    }
}
