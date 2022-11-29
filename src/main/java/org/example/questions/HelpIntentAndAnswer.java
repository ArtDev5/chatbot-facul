package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;

public class HelpIntentAndAnswer implements Question {
    @Override
    public boolean verifyIntent(MessageEntity messageEntity) {
        String intent = messageEntity.getIntent();
        return intent.equals("Help");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        return "Até o momento sou capaz de responder sobre o nome e a idade do meu desenvolvedor. Além disso sou " +
                "capaz de receber pedidos de pizza.";
    }
}
