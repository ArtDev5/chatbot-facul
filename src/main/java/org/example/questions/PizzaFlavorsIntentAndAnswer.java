package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;

public class PizzaFlavorsIntentAndAnswer implements Question {

    private ContextManagerImpl manager;
    public PizzaFlavorsIntentAndAnswer(ContextManagerImpl manager) {
        this.manager = manager;
    }

    @Override
    public boolean verifyIntent(MessageEntity messageEntity) {
        String userId = messageEntity.getUserId();
        String flag = manager.getContextData(userId, "flag");

        return messageEntity.getIntent().equals("Sabores") && flag.equals("flavors");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        String userId = messageEntity.getUserId();
        String message = messageEntity.getUserMessage();

        manager.deleteContextData(userId, "flag");

        return String.format("Certo. Sua pizza de sabor %s já está sendo preparada.", message);
    }
}
