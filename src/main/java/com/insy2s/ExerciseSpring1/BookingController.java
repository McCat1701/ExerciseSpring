package com.insy2s.ExerciseSpring1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Exercice 9 : Gestion des réservations de salles
//réez un contrôleur BookingController pour gérer les réservations :
//POST /bookings
//Ajoute une réservation { "room": "Salle A", "date": "2024-02-01" }.
//Retourne 201 Created "Réservation confirmée avec ID X".
//PUT /bookings/{id}
//Modifie une réservation { "date": "2024-02-02" }.
//Retourne 200 OK si mis à jour, 404 Not Found sinon.
//DELETE /bookings/{id}
//Annule une réservation.
//Retourne 200 OK si réussi, 404 Not Found sinon.
//

@RestController
@RequestMapping("/booking")
public class BookingController {

    private ArrayList<Booking>bookings=new ArrayList<>();

    @PostMapping()
    public ResponseEntity <String> AddBooking(@RequestBody Booking booking)
    {
        booking.setId(bookings.size());
        bookings.add(booking);

        return ResponseEntity.status(HttpStatus.CREATED).body("Produit Enregistré");

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> ModifiProduct(@PathVariable int id, @RequestBody Booking booking)
    {
        Booking book = null ;

        for (Booking p :bookings)
        {
            if(p.getId()==id)
            {
                book=p;
                break;
            }
        }

        if(book == null )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
        {
            if(booking.getRoom()!=null)
                book.setRoom(booking.getRoom());
            if(booking.getDate()!=null)
                book.setDate(booking.getDate());

            return ResponseEntity.status(HttpStatus.OK).body("Produit modifié");

        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable int id)
    {
        boolean conf = false;

        for(Booking P :bookings)
        {
            if(P.getId()==id)
                conf=bookings.remove(P);

        }
        if(conf==false)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé.");
        else
            return ResponseEntity.status(HttpStatus.OK).body("Produit supprimé");

    }

}
