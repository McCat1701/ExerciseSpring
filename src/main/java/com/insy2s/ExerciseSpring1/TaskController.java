package com.insy2s.ExerciseSpring1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Exercice 6 : Gestion d'une liste de tâches
//Créez un contrôleur TaskController pour gérer une liste de tâches avec les fonctionnalités suivantes :
//POST /tasks
//Ajoute une nouvelle tâche envoyée sous forme de JSON { "title": "Faire les courses" }.
//Retourne 201 Created avec un message "Tâche ajoutée avec l'ID X".
//PUT /tasks/{id}
//Met à jour le titre d'une tâche existante { "title": "Nouvelle description" }.
//Retourne 200 OK si mise à jour réussie, sinon 404 Not Found.
//DELETE /tasks/{id}
//Supprime une tâche par son ID.
//Retourne 200 OK si supprimé, sinon 404 Not Found.
//
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();


    @PostMapping("")
    public ResponseEntity<String>  addTask(@RequestParam Task task)
    {
        tasks.add(task);

        return  ResponseEntity.status(HttpStatus.CREATED ).body("tache creer");
    }

}
