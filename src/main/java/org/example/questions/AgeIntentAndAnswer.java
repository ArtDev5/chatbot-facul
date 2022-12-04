package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;

public class AgeIntentAndAnswer implements Question {

    private ContextManagerImpl manager;
    public AgeIntentAndAnswer(ContextManagerImpl manager) {
        this.manager = manager;
    }

    @Override
    public boolean verifyIntent(MessageEntity messageEntity){
        String intent = messageEntity.getIntent();

        String userId = messageEntity.getUserId();
        String flag = manager.getContextData(userId, "flag");

        return intent.equals("Age") && flag.equals("");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity){
        return "21 anos.";
    }
}
