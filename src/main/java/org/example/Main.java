package org.example;

import org.example.dialogflow.DialogflowServices;
import org.example.interfaces.Question;
import org.example.questions.*;
import org.example.services.BotServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DialogflowServices dialogflowServices(RestTemplate restTemplate){
        return new DialogflowServices(restTemplate);
    }

    @Bean
    public AgeIntentAndAnswer ageQuestionAndAnswer(){
        return new AgeIntentAndAnswer();
    }

    @Bean
    public NameIntentAndAnswer nameQuestionAndAnswer(){
        return new NameIntentAndAnswer();
    }

    @Bean
    public GreetingsIntentAndAnswer greetingsQuestionsAndAnswers(){
        return new GreetingsIntentAndAnswer();
    }

    @Bean
    public HelpIntentAndAnswer helpIntentAndAnswer(){
        return new HelpIntentAndAnswer();
    }

    @Bean
    public PizzaIntentAndAnswer pizzaIntentAndAnswer() {
        return new PizzaIntentAndAnswer();
    }

    @Bean
    public IntentsAndAnswers questionsAndAnswers(AgeIntentAndAnswer ageIntentAndAnswer,
                                                 NameIntentAndAnswer nameIntentAndAnswer,
                                                 GreetingsIntentAndAnswer greetingsIntentAndAnswer,
                                                 HelpIntentAndAnswer helpIntentAndAnswer,
                                                 PizzaIntentAndAnswer pizzaIntentAndAnswer){

        List<Question> answersAndQuestions = new ArrayList<>();

        answersAndQuestions.add(helpIntentAndAnswer);
        answersAndQuestions.add(ageIntentAndAnswer);
        answersAndQuestions.add(nameIntentAndAnswer);
        answersAndQuestions.add(greetingsIntentAndAnswer);
        answersAndQuestions.add(pizzaIntentAndAnswer);
        return new IntentsAndAnswers(answersAndQuestions);
    }

    @Bean
    public BotServices botServices(RestTemplate restTemplate, DialogflowServices dialogflowServices,
                                   IntentsAndAnswers intentsAndAnswers){
        return new BotServices(restTemplate, dialogflowServices, intentsAndAnswers);
    }
}