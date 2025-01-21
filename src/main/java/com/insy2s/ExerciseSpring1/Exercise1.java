package com.insy2s.ExerciseSpring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Exercice 1 : Hello, Spring Boot !
//Créez un contrôleur qui expose une route GET /hello prenant un paramètre name via @RequestParam et retournant une réponse sous la forme :
//Exemple :
//Requête : GET /hello?name=Jean
//Réponse : "Bonjour, Jean !"
//
@RestController
public class Exercise1 {

    @GetMapping("/hello")
    public String hello (@RequestParam String name)
    {
        return "Bonjour "+name;
    }

}
