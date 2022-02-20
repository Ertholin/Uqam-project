package com.mindsoft.immobilierproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mindsoft.immobilierproject.model.Propriete;

@SpringBootApplication
public class ImmobilierprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmobilierprojectApplication.class, args);
        Propriete p = new Propriete();
        System.out.println(p.getPhoto());
        System.out.println("Started...");
    }

}
