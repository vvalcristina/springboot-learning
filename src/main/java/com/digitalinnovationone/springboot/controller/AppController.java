package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    //Nessa anotação injetaremos todos os valores cujo o inicio seja passado como parâmetrp
    @Value("${app.message}")
    private String appMessage;

    //Toda vez que subirmos a aplicação na porta 8080
    //Ele exibirá no browser a menssagem
    @GetMapping("/")
    public String getAppMessage(){
        return appMessage;
    }
}
