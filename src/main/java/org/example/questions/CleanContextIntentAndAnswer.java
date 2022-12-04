package org.example.questions;

import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;

public class CleanContextIntentAndAnswer implements Question {

    private final ContextManagerImpl contextManagerImpl;

    public CleanContextIntentAndAnswer(ContextManagerImpl contextManagerImpl){
        this.contextManagerImpl = contextManagerImpl;
    }
    @Override
    public boolean verifyIntent(MessageEntity messageEntity) {
        String intent = messageEntity.getIntent();
        return intent.equals("Get out of the flow");
    }

    @Override
    public String getAnswer(MessageEntity messageEntity) {
        String userId = messageEntity.getUserId();

        String flag = contextManagerImpl.getContextData(userId, "flag");
        if(!flag.equals("")){
            contextManagerImpl.clearContext(userId);
            return "Ok, fluxo quebrado.";
        }else{
            return "Você precisa estar em um fluxo para poder utilizar essa função.";
        }
    }
}
