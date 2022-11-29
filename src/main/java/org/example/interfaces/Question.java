package org.example.interfaces;

import org.example.entities.MessageEntity;

public interface Question {

    boolean verifyIntent(MessageEntity messageEntity);
    String getAnswer(MessageEntity messageEntity);
}
