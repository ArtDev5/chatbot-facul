package org.example.controller;

import org.example.messenger.ReceiveEvent;
import org.example.messenger.ReceiveMessage;
import org.example.services.BotServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class Controller {

    @Value("${verifyToken}")
    private String verifyToken;
    @Value("${responseUrl}")
    private String responseUrl;

    BotServices bot;

    public Controller(BotServices bot){
        this.bot = bot;
    }

    @GetMapping
    public ResponseEntity<String> validateWebhookOnFacebook(@RequestParam(value = "hub.verify_token") String token,
                                                            @RequestParam(value = "hub.challenge") String challenge){
        if(token.equals(verifyToken)){
            return ResponseEntity.ok(challenge);
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> getAnswer(@RequestBody ReceiveEvent event){

        ReceiveMessage receiveMessage = new ReceiveMessage(event);

        bot.answerUser(receiveMessage, responseUrl);

        return ResponseEntity.ok().build();
    }
}
