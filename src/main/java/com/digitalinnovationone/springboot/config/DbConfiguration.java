package com.digitalinnovationone.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//Arquivo de configurações
//@ConfigurationProperties: Mapear todos os arquivos com o prefixo definido
//Para gerarmos getters e setter adicionamos o lombok
@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DbConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //Declaração de métodos que farão o mapeamento dessas propriedade
    //Método é instanciado como bean pq queremos que esse metodo seja instanciado logo na subida do spring

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB connection for DEV-H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Conncection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB connection for Production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Conncection to MYSQL_PROD - Production instance";
    }
}
