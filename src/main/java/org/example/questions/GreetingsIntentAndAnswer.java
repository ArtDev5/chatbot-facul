package org.example.questions;
import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;

public class GreetingsIntentAndAnswer implements Question {

    private ContextManagerImpl manager;
    public GreetingsIntentAndAnswer(ContextManagerImpl manager) {
        this.manager = manager;
    }

    @Override
    public boolean verifyIntent(MessageEntity messageEntity){
        String intent = messageEntity.getIntent();

        String userId = messageEntity.getUserId();
        String flag = manager.getContextData(userId, "flag");

        return intent.equals("Greetings") && flag.equals("");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity){
        return "Olá! Meu nome é TurBot e tenho quase um mês de vida. Caso não esteja familiarizado comigo, envie " +
                "'help' para saber sobre o que posso fazer.";
    }
}