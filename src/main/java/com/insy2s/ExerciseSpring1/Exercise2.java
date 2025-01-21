package com.insy2s.ExerciseSpring1;
//Créez un contrôleur CalculatorController qui expose une route GET /add prenant deux paramètres a et b via @RequestParam et retournant leur somme.
//Exemple :
//Requête : GET /add?a=5&b=3
//Réponse : "Résultat : 8"
//Ajoutez une autre route GET /multiply/{a}/{b} utilisant @PathVariable pour effectuer une multiplication.
//Exemple :
//Requête : GET /multiply/4/2
//Réponse : "Résultat : 8"
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise2 {

    @GetMapping ("/add")
    public String Calculatoradd(@RequestParam int a ,@RequestParam int b)
    {
        int res = a+b;
        return "resultat : "+res;

    }

    @GetMapping("/multiply/{a}/{b}")
    public String CalculatorMultiply(@PathVariable int a ,@PathVariable int b )
    {
        int res = a*b;
        return "resultat : "+res;
    }
}
