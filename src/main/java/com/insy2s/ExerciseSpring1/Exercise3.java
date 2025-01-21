package com.insy2s.ExerciseSpring1;
//Créez un contrôleur UserController avec une liste statique d'utilisateurs sous forme de Map<Integer, String> (clé = ID, valeur = nom).
//Exposez deux routes :
//GET /user/{id} qui retourne le nom de l'utilisateur correspondant à l'ID fourni avec @PathVariable.
//Exemple :
//GET /user/1 → "Utilisateur : Alice"
//GET /user/all qui retourne tous les utilisateurs sous forme de liste.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Exercise3 {

    @GetMapping("/user/{id}")
    public String UserControler(@PathVariable int id )
    {
        Map<Integer , String >users = new HashMap<>();
        users.put(1,"alice");

        return "utilisateur : "+ users.get(id);
    }
}
