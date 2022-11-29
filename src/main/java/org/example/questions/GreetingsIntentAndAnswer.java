package org.example.questions;
import org.example.entities.MessageEntity;
import org.example.interfaces.Question;

public class GreetingsIntentAndAnswer implements Question {

    @Override
    public boolean verifyIntent(MessageEntity messageEntity){
        String intent = messageEntity.getIntent();

        return intent.equals("Greetings");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity){
        return "Olá! Chamo-me TurBot e tenho quase dois meses de vida. Caso não esteja familiarizado comigo, envie " +
                "'help' para saber sobre o que posso fazer";
    }
}