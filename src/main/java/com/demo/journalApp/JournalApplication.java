package com.demo.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(JournalApplication.class, args);
        String[] envs = applicationContext.getEnvironment().getActiveProfiles() ;
        System.out.println(envs);
    }

    @Bean
    public PlatformTransactionManager transBean(MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }
}