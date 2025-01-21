package com.insy2s.ExerciseSpring1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserControler {

  private static  ArrayList<User> users = new ArrayList<>();

 /* @PostMapping("")
  public ResponseEntity<String> emptypost ()
    {

        return  ResponseEntity.status(HttpStatus.OK).body("connected");
    }

*/

    @PostMapping("")
    public ResponseEntity<String> AddUser(@RequestBody User user)
    {

        user.setId(users.size());
        users.add(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur ajouté avec id "+user.getId()+".");

    }
    @PutMapping("/{id}")
    public ResponseEntity<String > PutUser (@PathVariable int id,@RequestBody User user)
    {
        User use =null;
        for (User u : users )
        {
            if (u.getId()==id)
                use=u;
        }
        if(use ==null )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        else
        {
            if(user.getName()!=null)
                use.setName(user.getName());
            if(user.getEmail()!=null)
                use.setEmail(user.getEmail());

            return ResponseEntity.status((HttpStatus.OK)).body("Utilisateur modifié.");
        }



    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String > DeleteUser(@PathVariable int id){

        boolean conf =false;
        for(User u : users )
        {
            if(u.getId()==id) {
                conf = users.remove(u);
                break;
            }
        }
        if(conf==false)
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("utilisateur non toruvé");
        else
            return ResponseEntity.status(HttpStatus.OK).body("Utilisateur supprimé");

    }

}
