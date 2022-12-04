package org.example.controller;

import org.example.entities.UserInput;
import org.example.services.BotServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bot")
public class Controller {

    @Value("${verifyToken}")
    private String verifyToken;
    @Value("${responseUrl}")
    private String responseUrl;

    BotServices bot;

    public Controller(BotServices bot){
        this.bot = bot;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> getAnswer(@RequestBody UserInput userInput){
        return ResponseEntity.ok().body(Map.of("response", bot.answerUser(userInput)));
    }
}
