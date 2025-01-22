package com.insy2s.ExerciseSpring1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Exercice 10 : Gestion d'un blog
//Créez un contrôleur PostController pour gérer des articles de blog :
//POST /posts
//Ajoute un article { "title": "Spring Boot", "content": "Introduction à Spring Boot" }.
//Retourne 201 Created "Article ajouté avec l'ID X".
//PUT /posts/{id}
//Met à jour un article { "title": "Mise à jour", "content": "Contenu mis à jour" }.
//Retourne 200 OK si modifié, 404 Not Found sinon.
//DELETE /posts/{id}
//Supprime un article.
//Retourne 200 OK si réussi, 404 Not Found sinon.
//
@RestController
public class PostControler {
    private ArrayList<Article> articles=new ArrayList<>();

    @PostMapping()
    public ResponseEntity<String> AddArticle(@RequestBody Article article)
    {
        article.setId(articles.size());
        articles.add(article);

        return ResponseEntity.status(HttpStatus.CREATED).body("Produit Enregistré");

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> ModifiProduct(@PathVariable int id, @RequestBody Article article)
    {
        Article art = null ;

        for (Article p :articles)
        {
            if(p.getId()==id)
            {
                art=p;
                break;
            }
        }

        if(art == null )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
        {
            if(article.getTitre()!=null)
                art.setTitre(article.getTitre());
            if(article.getContent()!=null)
                art.setContent(article.getContent());

            return ResponseEntity.status(HttpStatus.OK).body("Produit modifié");

        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable int id)
    {
        boolean conf = false;

        for(Article P :articles)
        {
            if(P.getId()==id)
                conf=articles.remove(P);

        }
        if(conf==false)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
            return ResponseEntity.status(HttpStatus.OK).body("Produit supprimé");

    }



}
