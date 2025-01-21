package com.insy2s.ExerciseSpring1;

//Exercice 5 : Gestion de produits
//Créez un contrôleur ProductController qui gère une liste de produits sous forme de Map<Integer, String>.
//Exposez trois routes :
//GET /product/{id} → Retourne le produit correspondant à l'ID (@PathVariable).
//GET /product/add?name=XXX → Ajoute un produit (@RequestParam).
//GET /product/all → Retourne la liste des produits.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Exercise5 {

    private static  Map<Integer,String > Produit;

    public Exercise5 ()
    {
        Produit=new HashMap<>();
        Produit.put(1,"DVD");
    }

    @GetMapping ("product/{id}")
public String GetProduit (@PathVariable int id )
{

    return Produit.getOrDefault(id, "Produit n'existe pas");
}

@GetMapping("/product")
public String AddProduit(@RequestParam String  name )
{
    int max = Collections.max(Produit.keySet());

    Produit.put(max+1,name);

    return "produit ajouté ";
}

@GetMapping("product/all")
public String allProduit ()
{
    String res = "";

    for (Map.Entry<Integer,String > entry :Produit.entrySet())
    {
        res=res+""+entry.getKey() +" : "+entry.getValue() +"<br/>";
    }

    return res;
}

}
