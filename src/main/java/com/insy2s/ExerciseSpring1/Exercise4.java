package com.insy2s.ExerciseSpring1;
//Créez un contrôleur TemperatureController qui expose une route GET /convert avec un paramètre @RequestParam(value="celsius") convertissant la température en Fahrenheit.
//Formule : F = (C × 9/5) + 32
//Exemple :
//GET /convert?celsius=25
//Réponse : "25°C = 77°F"

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise4 {

    @GetMapping("/convert")
    public String getFarenheit(@RequestParam int celcius )
    {
        double F = (celcius*(9.0/5.0) )+32;

        return celcius+"°C ="+F+"F";

    }


}
