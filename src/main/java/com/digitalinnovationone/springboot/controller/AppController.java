package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    //Nessa anotação injetaremos todos os valores cujo o inicio seja passado como parâmetrp
    @Value("${app.message}")
    private String appMessage;

    //Variável de ambiente
    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVariable;

    //Toda vez que subirmos a aplicação na porta 8080
    //Ele exibirá no browser a menssagem
    @GetMapping("/")
    public String getAppMessage(){
        return appMessage;
    }

    @GetMapping("/envVariable")
    public String getDbEnvironmentVariable(){
        return "A seguinte variável de ambiente foi passada: " + dbEnvironmentVariable;
    }
}
