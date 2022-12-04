package org.example;

import org.example.dialogflow.DialogflowServices;
import org.example.interfaces.Question;
import org.example.manager.ContextManagerImpl;
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
    public ContextManagerImpl messageContextTest(){
        return new ContextManagerImpl();
    }

    @Bean
    public AgeIntentAndAnswer ageQuestionAndAnswer(ContextManagerImpl contextManager){
        return new AgeIntentAndAnswer(contextManager);
    }

    @Bean
    public NameIntentAndAnswer nameQuestionAndAnswer(ContextManagerImpl contextManager){
        return new NameIntentAndAnswer(contextManager);
    }

    @Bean
    public GreetingsIntentAndAnswer greetingsQuestionsAndAnswers(ContextManagerImpl contextManager){
        return new GreetingsIntentAndAnswer(contextManager);
    }

    @Bean
    public HelpIntentAndAnswer helpIntentAndAnswer(){
        return new HelpIntentAndAnswer();
    }

    @Bean
    public PizzaIntentAndAnswer pizzaIntentAndAnswer(ContextManagerImpl contextManager) {
        return new PizzaIntentAndAnswer(contextManager);
    }

    @Bean
    public PizzaFlavorsIntentAndAnswer pizzaFlavorsIntentAndAnswer(ContextManagerImpl contextManager) {
        return new PizzaFlavorsIntentAndAnswer(contextManager);
    }

    @Bean
    public CleanContextIntentAndAnswer cleanContextIntentAndAnswer(ContextManagerImpl contextManager) {
        return new CleanContextIntentAndAnswer(contextManager);
    }

    @Bean
    public IntentsAndAnswers questionsAndAnswers(CleanContextIntentAndAnswer cleanContextIntentAndAnswer,
                                                 AgeIntentAndAnswer ageIntentAndAnswer,
                                                 NameIntentAndAnswer nameIntentAndAnswer,
                                                 GreetingsIntentAndAnswer greetingsIntentAndAnswer,
                                                 HelpIntentAndAnswer helpIntentAndAnswer,
                                                 PizzaIntentAndAnswer pizzaIntentAndAnswer,
                                                 PizzaFlavorsIntentAndAnswer pizzaFlavorsIntentAndAnswer){

        List<Question> answersAndQuestions = new ArrayList<>();

        answersAndQuestions.add(cleanContextIntentAndAnswer);
        answersAndQuestions.add(pizzaFlavorsIntentAndAnswer);
        answersAndQuestions.add(helpIntentAndAnswer);
        answersAndQuestions.add(ageIntentAndAnswer);
        answersAndQuestions.add(nameIntentAndAnswer);
        answersAndQuestions.add(greetingsIntentAndAnswer);
        answersAndQuestions.add(pizzaIntentAndAnswer);
        return new IntentsAndAnswers(answersAndQuestions);
    }

    @Bean
    public BotServices botServices(DialogflowServices dialogflowServices,
                                   IntentsAndAnswers intentsAndAnswers){
        return new BotServices(dialogflowServices, intentsAndAnswers);
    }
}