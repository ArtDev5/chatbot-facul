package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;

public class PizzaIntentAndAnswer implements Question {

    private ContextManagerImpl manager;
    public PizzaIntentAndAnswer(ContextManagerImpl manager) {
        this.manager = manager;
    }
    @Override
    public boolean verifyIntent(MessageEntity messageEntity) {
        String userId = messageEntity.getUserId();
        String flag = manager.getContextData(userId, "flag");

        return messageEntity.getIntent().equals("Pizza") && flag.equals("");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        String userId = messageEntity.getUserId();
        manager.setContextData(userId, "flag", "flavors");
        return "Certo. Diga-me o sabor que deseja!!";
    }
}
