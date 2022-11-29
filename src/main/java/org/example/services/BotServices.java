package org.example.services;

import org.example.dialogflow.DialogflowServices;
import org.example.entities.DialogflowEntitiesData;
import org.example.entities.MessageEntity;
import org.example.interfaces.Question;
import org.example.messenger.ReceiveMessage;
import org.example.messenger.ResponseEvent;
import org.example.questions.IntentsAndAnswers;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class BotServices {

    private final RestTemplate restTemplate;
    private final DialogflowServices dialogflow;
    private final IntentsAndAnswers intentsAndAnswers;

    public BotServices(RestTemplate restTemplate, DialogflowServices dialogflow,
                       IntentsAndAnswers intentsAndAnswers){
        this.restTemplate = restTemplate;
        this.dialogflow = dialogflow;
        this.intentsAndAnswers = intentsAndAnswers;
    }

    @Async
    public void answerUser(ReceiveMessage message, String responseUrl){
        String userId = message.getUserId();
        String userMessage = message.getUserMessage();

        String answer = getAnswer(userMessage, userId);

        ResponseEvent response = new ResponseEvent(userId, answer);

        HttpEntity<ResponseEvent> entity = new HttpEntity<>(response);

        restTemplate.postForEntity(responseUrl, entity, String.class);
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
