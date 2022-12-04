package org.example.services;

import org.example.dialogflow.DialogflowServices;
import org.example.entities.DialogflowEntitiesData;
import org.example.entities.MessageEntity;
import org.example.entities.UserInput;
import org.example.interfaces.Question;
import org.example.questions.IntentsAndAnswers;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

public class BotServices {

    private final DialogflowServices dialogflow;
    private final IntentsAndAnswers intentsAndAnswers;

    public BotServices(DialogflowServices dialogflow,
                       IntentsAndAnswers intentsAndAnswers){
        this.dialogflow = dialogflow;
        this.intentsAndAnswers = intentsAndAnswers;
    }

    @Async
    public String answerUser(UserInput userInput){
        String userId = userInput.getUserId();
        String userMessage = userInput.getUserMessage();

        return getAnswer(userMessage, userId);
    }

    private String getAnswer(String userMessage, String userId){

        DialogflowEntitiesData dialogflowEntitiesData = dialogflow.getDialogflowData(userMessage);

        String intent = dialogflowEntitiesData.getIntent();

        Map<String, String> entities = dialogflowEntitiesData.getEntities();

        MessageEntity messageEntity = new MessageEntity(userMessage, userId, intent, entities);

        for(Question values: intentsAndAnswers.getQuestionsWithAnswers()){
            if(values.verifyIntent(messageEntity)){
                return values.getAnswer(messageEntity);
            }
        }
        return "Desculpe-me, não entendi.";
    }
}
