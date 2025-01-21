package com.insy2s.ExerciseSpring1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/// Exercice 8 : Inventaire de produits
/// Créez un contrôleur ProductController pour gérer un inventaire :
/// POST /products
/// Ajoute un produit avec { "name": "Laptop", "price": 999.99 }.
/// Retourne 201 Created avec "Produit ajouté avec l'ID X".
/// PUT /products/{id}
/// Met à jour le prix d'un produit { "price": 899.99 }.
/// Retourne 200 OK si modification réussie, 404 Not Found sinon.
/// DELETE /products/{id}
/// Supprime un produit de l’inventaire.
/// Retourne 200 OK si réussi, 404 Not Found sinon.
///
@RestController
@RequestMapping("/products")
public class ProductController {

    private ArrayList<Product> products =new ArrayList<>();

    @PostMapping()
        public ResponseEntity<String> AddProduct(@RequestBody Product product)
    {
        product.setId(products.size());
        products.add(product);

        return ResponseEntity.status(HttpStatus.CREATED).body("Produit Enregistré");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ModifiProduct(@PathVariable int id, @RequestBody Product product)
    {
        Product prod = null ;

        for (Product p :products)
        {
            if(p.getId()==id)
            {
                prod=p;
                break;
            }
        }

        if(prod == null )
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
        {
            if(product.getName()!=null)
                prod.setName(product.getName());
            if(product.getPrice()!=-1)
                prod.setPrice(product.getPrice());

            return ResponseEntity.status(HttpStatus.OK).body("Produit modifié");

        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable int id)
    {
        boolean conf = false;

        for(Product P :products)
        {
            if(P.getId()==id)
                conf=products.remove(P);

        }
        if(conf==false)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
            return ResponseEntity.status(HttpStatus.OK).body("Produit supprimé");

    }

}
